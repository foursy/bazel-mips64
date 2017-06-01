// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.buildjar;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.devtools.build.buildjar.instrumentation.JacocoInstrumentationProcessor;
import com.google.devtools.build.buildjar.javac.BlazeJavacArguments;
import com.google.devtools.build.buildjar.javac.plugins.BlazeJavaCompilerPlugin;
import com.google.devtools.build.buildjar.javac.plugins.dependency.DependencyModule;
import com.google.devtools.build.buildjar.javac.plugins.processing.AnnotationProcessingModule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/** All the information needed to perform a single Java library build operation. */
public final class JavaLibraryBuildRequest {
  private ImmutableList<String> javacOpts;

  /** Where to store source files generated by annotation processors. */
  private final String sourceGenDir;

  /** The path to an output jar for source files generated by annotation processors. */
  private final String generatedSourcesOutputJar;

  /** The path to an output jar for classfiles generated by annotation processors. */
  private final String generatedClassOutputJar;

  private final ArrayList<Path> sourceFiles;
  private final ImmutableList<String> sourceJars;
  private final ImmutableList<String> messageFiles;
  private final ImmutableList<String> resourceFiles;
  private final ImmutableList<String> resourceJars;
  /** Resource files that should be put in the root of the output jar. */
  private final ImmutableList<String> rootResourceFiles;

  private final String sourcePath;
  private final String classPath;
  private final String bootClassPath;
  private final String extdir;

  private final String processorPath;
  private final List<String> processorNames;

  private final String outputJar;

  private final String classDir;
  private final String tempDir;

  private JacocoInstrumentationProcessor jacocoInstrumentationProcessor;

  private final boolean compressJar;

  /** Repository for all dependency-related information. */
  private final DependencyModule dependencyModule;

  /** Repository for information about annotation processor-generated symbols. */
  private final AnnotationProcessingModule processingModule;

  /** List of plugins that are given to javac. */
  private final ImmutableList<BlazeJavaCompilerPlugin> plugins;

  /**
   * Constructs a build from a list of command args. Sets the same JavacRunner for both compilation
   * and annotation processing.
   *
   * @param optionsParser the parsed command line args.
   * @param extraPlugins extraneous plugins to use in addition to the strict dependency module.
   * @throws InvalidCommandLineException on any command line error
   */
  public JavaLibraryBuildRequest(
      OptionsParser optionsParser, List<BlazeJavaCompilerPlugin> extraPlugins)
      throws InvalidCommandLineException, IOException {
    this(optionsParser, extraPlugins, new DependencyModule.Builder());
  }

  /**
   * Constructs a build from a list of command args. Sets the same JavacRunner for both compilation
   * and annotation processing.
   *
   * @param optionsParser the parsed command line args.
   * @param extraPlugins extraneous plugins to use in addition to the strict dependency module.
   * @param depsBuilder a preconstructed dependency module builder.
   * @throws InvalidCommandLineException on any command line error
   */
  public JavaLibraryBuildRequest(
      OptionsParser optionsParser,
      List<BlazeJavaCompilerPlugin> extraPlugins,
      DependencyModule.Builder depsBuilder)
      throws InvalidCommandLineException, IOException {
    depsBuilder.addDirectMappings(optionsParser.getDirectMappings());
    depsBuilder.addIndirectMappings(optionsParser.getIndirectMappings());
    if (optionsParser.getStrictJavaDeps() != null) {
      depsBuilder.setStrictJavaDeps(optionsParser.getStrictJavaDeps());
    }
    if (optionsParser.getOutputDepsProtoFile() != null) {
      depsBuilder.setOutputDepsProtoFile(optionsParser.getOutputDepsProtoFile());
    }
    depsBuilder.addDepsArtifacts(optionsParser.getDepsArtifacts());
    if (optionsParser.reduceClasspath()) {
      depsBuilder.setReduceClasspath();
    }
    if (optionsParser.getRuleKind() != null) {
      depsBuilder.setRuleKind(optionsParser.getRuleKind());
    }
    if (optionsParser.getTargetLabel() != null) {
      depsBuilder.setTargetLabel(optionsParser.getTargetLabel());
    }
    this.dependencyModule = depsBuilder.build();

    AnnotationProcessingModule.Builder processingBuilder = AnnotationProcessingModule.builder();
    if (optionsParser.getSourceGenDir() != null) {
      processingBuilder.setSourceGenDir(Paths.get(optionsParser.getSourceGenDir()));
    }
    if (optionsParser.getManifestProtoPath() != null) {
      processingBuilder.setManifestProtoPath(Paths.get(optionsParser.getManifestProtoPath()));
    }
    processingBuilder.addAllSourceRoots(optionsParser.getSourceRoots());
    this.processingModule = processingBuilder.build();

    ImmutableList.Builder<BlazeJavaCompilerPlugin> pluginsBuilder =
        ImmutableList.<BlazeJavaCompilerPlugin>builder().add(dependencyModule.getPlugin());
    processingModule.registerPlugin(pluginsBuilder);
    pluginsBuilder.addAll(extraPlugins);
    this.plugins = pluginsBuilder.build();

    this.compressJar = optionsParser.compressJar();
    this.sourceFiles = new ArrayList<>(toPaths(optionsParser.getSourceFiles()));
    this.sourceJars = ImmutableList.copyOf(optionsParser.getSourceJars());
    this.messageFiles = ImmutableList.copyOf(optionsParser.getMessageFiles());
    this.resourceFiles = ImmutableList.copyOf(optionsParser.getResourceFiles());
    this.resourceJars = ImmutableList.copyOf(optionsParser.getResourceJars());
    this.rootResourceFiles = ImmutableList.copyOf(optionsParser.getRootResourceFiles());
    this.classPath = optionsParser.getClassPath();
    this.sourcePath = optionsParser.getSourcePath();
    this.bootClassPath = optionsParser.getBootClassPath();
    this.extdir = optionsParser.getExtdir();
    this.processorPath = optionsParser.getProcessorPath();
    this.processorNames = optionsParser.getProcessorNames();
    // Since the default behavior of this tool with no arguments is "rm -fr <classDir>", let's not
    // default to ".", shall we?
    if (optionsParser.getClassDir() != null) {
      this.classDir = optionsParser.getClassDir();
    } else {
      this.classDir = "classes";
    }
    if (optionsParser.getTempDir() != null) {
      this.tempDir = optionsParser.getTempDir();
    } else {
      this.tempDir = "_tmp";
    }
    this.outputJar = optionsParser.getOutputJar();
    for (Entry<String, List<String>> entry : optionsParser.getPostProcessors().entrySet()) {
      switch (entry.getKey()) {
        case "jacoco":
          this.jacocoInstrumentationProcessor =
              JacocoInstrumentationProcessor.create(entry.getValue());
          break;
        default:
          throw new AssertionError("unsupported post-processor " + entry.getKey());
      }
    }
    this.javacOpts = ImmutableList.copyOf(optionsParser.getJavacOpts());
    this.sourceGenDir = optionsParser.getSourceGenDir();
    this.generatedSourcesOutputJar = optionsParser.getGeneratedSourcesOutputJar();
    this.generatedClassOutputJar = optionsParser.getManifestProtoPath();
  }

  public ImmutableList<String> getJavacOpts() {
    return javacOpts;
  }

  public void setJavacOpts(List<String> javacOpts) {
    this.javacOpts = ImmutableList.copyOf(javacOpts);
  }

  public String getSourceGenDir() {
    return sourceGenDir;
  }

  public String getSourcePath() {
    return sourcePath;
  }

  public String getGeneratedSourcesOutputJar() {
    return generatedSourcesOutputJar;
  }

  public String getGeneratedClassOutputJar() {
    return generatedClassOutputJar;
  }

  public ArrayList<Path> getSourceFiles() {
    // TODO(cushon): This is being modified after parsing to add files from source jars.
    return sourceFiles;
  }

  public ImmutableList<String> getSourceJars() {
    return sourceJars;
  }

  public ImmutableList<String> getMessageFiles() {
    return messageFiles;
  }

  public ImmutableList<String> getResourceFiles() {
    return resourceFiles;
  }

  public ImmutableList<String> getResourceJars() {
    return resourceJars;
  }

  public ImmutableList<String> getRootResourceFiles() {
    return rootResourceFiles;
  }

  public String getClassPath() {
    return classPath;
  }

  public String getBootClassPath() {
    return bootClassPath;
  }

  public String getExtdir() {
    return extdir;
  }

  public String getProcessorPath() {
    return processorPath;
  }

  public List<String> getProcessors() {
    // TODO(bazel-team): This might be modified by a JavaLibraryBuilder to enable specific
    // annotation processors.
    return processorNames;
  }

  public String getOutputJar() {
    return outputJar;
  }

  public String getClassDir() {
    return classDir;
  }

  public String getTempDir() {
    return tempDir;
  }

  public JacocoInstrumentationProcessor getJacocoInstrumentationProcessor() {
    return jacocoInstrumentationProcessor;
  }

  public boolean compressJar() {
    return compressJar;
  }

  public DependencyModule getDependencyModule() {
    return dependencyModule;
  }

  public AnnotationProcessingModule getProcessingModule() {
    return processingModule;
  }

  public ImmutableList<BlazeJavaCompilerPlugin> getPlugins() {
    return plugins;
  }

  public BlazeJavacArguments toBlazeJavacArguments(final String classPath) {
    return BlazeJavacArguments.builder()
        .classPath(toPaths(classPath))
        .classOutput(Paths.get(getClassDir()))
        .bootClassPath(
            ImmutableList.copyOf(
                Iterables.concat(toPaths(getBootClassPath()), toPaths(getExtdir()))))
        .javacOptions(makeJavacArguments())
        .sourceFiles(ImmutableList.copyOf(getSourceFiles()))
        .processors(null)
        .sourcePath(toPaths(getSourcePath()))
        .sourceOutput(getSourceGenDir() != null ? Paths.get(getSourceGenDir()) : null)
        .processorPath(toPaths(getProcessorPath()))
        .plugins(getPlugins())
        .build();
  }

  static ImmutableList<Path> toPaths(List<String> files) {
    if (files == null) {
      return ImmutableList.of();
    }
    ImmutableList.Builder<Path> result = ImmutableList.builder();
    for (String e : files) {
      result.add(Paths.get(e));
    }
    return result.build();
  }

  static ImmutableList<Path> toPaths(String classPath) {
    if (classPath == null) {
      return ImmutableList.of();
    }
    ImmutableList.Builder<Path> result = ImmutableList.builder();
    for (String e : Splitter.on(File.pathSeparatorChar).split(classPath)) {
      result.add(Paths.get(e));
    }
    return result.build();
  }

  /** Constructs a command line that can be used for a javac invocation. */
  ImmutableList<String> makeJavacArguments() {
    ImmutableList.Builder<String> javacArguments = ImmutableList.builder();
    // default to -implicit:none, but allow the user to override with -implicit:class.
    javacArguments.add("-implicit:none");
    javacArguments.addAll(getJavacOpts());

    if (!getProcessors().isEmpty() && !getSourceFiles().isEmpty()) {
      // ImmutableSet.copyOf maintains order
      ImmutableSet<String> deduplicatedProcessorNames = ImmutableSet.copyOf(getProcessors());
      javacArguments.add("-processor");
      javacArguments.add(Joiner.on(',').join(deduplicatedProcessorNames));
    } else {
      // This is necessary because some jars contain discoverable annotation processors that
      // previously didn't run, and they break builds if the "-proc:none" option is not passed to
      // javac.
      javacArguments.add("-proc:none");
    }

    for (String option : getJavacOpts()) {
      if (option.startsWith("-J")) { // ignore the VM options.
        continue;
      }
      if (option.equals("-processor") || option.equals("-processorpath")) {
        throw new IllegalStateException(
            "Using "
                + option
                + " in javacopts is no longer supported."
                + " Use a java_plugin() rule instead.");
      }
    }

    return javacArguments.build();
  }
}
