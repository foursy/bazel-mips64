// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bazel-out/local-fastbuild/bin/src/main/protobuf/libextra_actions_base_java_proto_srcjar.srcjar.preprocessed/extra_actions_base.proto

package com.google.devtools.build.lib.actions.extra;

public final class ExtraActionsBase {
  private ExtraActionsBase() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(com.google.devtools.build.lib.actions.extra.SpawnInfo.spawnInfo);
    registry.add(com.google.devtools.build.lib.actions.extra.CppCompileInfo.cppCompileInfo);
    registry.add(com.google.devtools.build.lib.actions.extra.CppLinkInfo.cppLinkInfo);
    registry.add(com.google.devtools.build.lib.actions.extra.JavaCompileInfo.javaCompileInfo);
    registry.add(com.google.devtools.build.lib.actions.extra.PythonInfo.pythonInfo);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionSummary_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionSummary_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_DetailedExtraActionInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_DetailedExtraActionInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_AspectParametersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_AspectParametersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_StringList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_StringList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_AspectDescriptor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_AspectParametersEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_AspectDescriptor_AspectParametersEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_StringList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_ExtraActionInfo_AspectDescriptor_StringList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_EnvironmentVariable_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_EnvironmentVariable_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_SpawnInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_SpawnInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_CppCompileInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_CppCompileInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_CppLinkInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_CppLinkInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_JavaCompileInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_JavaCompileInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_blaze_PythonInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_blaze_PythonInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\204\001bazel-out/local-fastbuild/bin/src/mai" +
      "n/protobuf/libextra_actions_base_java_pr" +
      "oto_srcjar.srcjar.preprocessed/extra_act" +
      "ions_base.proto\022\005blaze\"D\n\022ExtraActionSum" +
      "mary\022.\n\006action\030\001 \003(\0132\036.blaze.DetailedExt" +
      "raActionInfo\"Z\n\027DetailedExtraActionInfo\022" +
      "\027\n\017triggering_file\030\001 \001(\t\022&\n\006action\030\002 \002(\013" +
      "2\026.blaze.ExtraActionInfo\"\364\004\n\017ExtraAction" +
      "Info\022\r\n\005owner\030\001 \001(\t\022\027\n\013aspect_name\030\006 \001(\t" +
      "B\002\030\001\022K\n\021aspect_parameters\030\007 \003(\0132,.blaze.",
      "ExtraActionInfo.AspectParametersEntryB\002\030" +
      "\001\0228\n\007aspects\030\010 \003(\0132\'.blaze.ExtraActionIn" +
      "fo.AspectDescriptor\022\n\n\002id\030\002 \001(\t\022\020\n\010mnemo" +
      "nic\030\005 \001(\t\032Z\n\025AspectParametersEntry\022\013\n\003ke" +
      "y\030\001 \001(\t\0220\n\005value\030\002 \001(\0132!.blaze.ExtraActi" +
      "onInfo.StringList:\0028\001\032\037\n\nStringList\022\r\n\005v" +
      "alue\030\001 \003(\t:\002\030\001\032\213\002\n\020AspectDescriptor\022\023\n\013a" +
      "spect_name\030\001 \001(\t\022X\n\021aspect_parameters\030\002 " +
      "\003(\0132=.blaze.ExtraActionInfo.AspectDescri" +
      "ptor.AspectParametersEntry\032k\n\025AspectPara",
      "metersEntry\022\013\n\003key\030\001 \001(\t\022A\n\005value\030\002 \001(\0132" +
      "2.blaze.ExtraActionInfo.AspectDescriptor" +
      ".StringList:\0028\001\032\033\n\nStringList\022\r\n\005value\030\001" +
      " \003(\t*\t\010\350\007\020\200\200\200\200\002\"2\n\023EnvironmentVariable\022\014" +
      "\n\004name\030\001 \002(\t\022\r\n\005value\030\002 \002(\t\"\263\001\n\tSpawnInf" +
      "o\022\020\n\010argument\030\001 \003(\t\022,\n\010variable\030\002 \003(\0132\032." +
      "blaze.EnvironmentVariable\022\022\n\ninput_file\030" +
      "\004 \003(\t\022\023\n\013output_file\030\005 \003(\t2=\n\nspawn_info" +
      "\022\026.blaze.ExtraActionInfo\030\353\007 \001(\0132\020.blaze." +
      "SpawnInfo\"\366\001\n\016CppCompileInfo\022\014\n\004tool\030\001 \001",
      "(\t\022\027\n\017compiler_option\030\002 \003(\t\022\023\n\013source_fi" +
      "le\030\003 \001(\t\022\023\n\013output_file\030\004 \001(\t\022\033\n\023sources" +
      "_and_headers\030\005 \003(\t\022,\n\010variable\030\006 \003(\0132\032.b" +
      "laze.EnvironmentVariable2H\n\020cpp_compile_" +
      "info\022\026.blaze.ExtraActionInfo\030\351\007 \001(\0132\025.bl" +
      "aze.CppCompileInfo\"\226\002\n\013CppLinkInfo\022\022\n\nin" +
      "put_file\030\001 \003(\t\022\023\n\013output_file\030\002 \001(\t\022\035\n\025i" +
      "nterface_output_file\030\003 \001(\t\022\030\n\020link_targe" +
      "t_type\030\004 \001(\t\022\027\n\017link_staticness\030\005 \001(\t\022\022\n" +
      "\nlink_stamp\030\006 \003(\t\022\"\n\032build_info_header_a",
      "rtifact\030\007 \003(\t\022\020\n\010link_opt\030\010 \003(\t2B\n\rcpp_l" +
      "ink_info\022\026.blaze.ExtraActionInfo\030\352\007 \001(\0132" +
      "\022.blaze.CppLinkInfo\"\200\002\n\017JavaCompileInfo\022" +
      "\021\n\toutputjar\030\001 \001(\t\022\021\n\tclasspath\030\002 \003(\t\022\022\n" +
      "\nsourcepath\030\003 \003(\t\022\023\n\013source_file\030\004 \003(\t\022\021" +
      "\n\tjavac_opt\030\005 \003(\t\022\021\n\tprocessor\030\006 \003(\t\022\025\n\r" +
      "processorpath\030\007 \003(\t\022\025\n\rbootclasspath\030\010 \003" +
      "(\t2J\n\021java_compile_info\022\026.blaze.ExtraAct" +
      "ionInfo\030\350\007 \001(\0132\026.blaze.JavaCompileInfo\"t" +
      "\n\nPythonInfo\022\023\n\013source_file\030\001 \003(\t\022\020\n\010dep",
      "_file\030\002 \003(\t2?\n\013python_info\022\026.blaze.Extra" +
      "ActionInfo\030\355\007 \001(\0132\021.blaze.PythonInfoB/\n+" +
      "com.google.devtools.build.lib.actions.ex" +
      "traP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_blaze_ExtraActionSummary_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_blaze_ExtraActionSummary_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionSummary_descriptor,
        new java.lang.String[] { "Action", });
    internal_static_blaze_DetailedExtraActionInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_blaze_DetailedExtraActionInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_DetailedExtraActionInfo_descriptor,
        new java.lang.String[] { "TriggeringFile", "Action", });
    internal_static_blaze_ExtraActionInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_blaze_ExtraActionInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_descriptor,
        new java.lang.String[] { "Owner", "AspectName", "AspectParameters", "Aspects", "Id", "Mnemonic", });
    internal_static_blaze_ExtraActionInfo_AspectParametersEntry_descriptor =
      internal_static_blaze_ExtraActionInfo_descriptor.getNestedTypes().get(0);
    internal_static_blaze_ExtraActionInfo_AspectParametersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_AspectParametersEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_blaze_ExtraActionInfo_StringList_descriptor =
      internal_static_blaze_ExtraActionInfo_descriptor.getNestedTypes().get(1);
    internal_static_blaze_ExtraActionInfo_StringList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_StringList_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_descriptor =
      internal_static_blaze_ExtraActionInfo_descriptor.getNestedTypes().get(2);
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_AspectDescriptor_descriptor,
        new java.lang.String[] { "AspectName", "AspectParameters", });
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_AspectParametersEntry_descriptor =
      internal_static_blaze_ExtraActionInfo_AspectDescriptor_descriptor.getNestedTypes().get(0);
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_AspectParametersEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_AspectDescriptor_AspectParametersEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_StringList_descriptor =
      internal_static_blaze_ExtraActionInfo_AspectDescriptor_descriptor.getNestedTypes().get(1);
    internal_static_blaze_ExtraActionInfo_AspectDescriptor_StringList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_ExtraActionInfo_AspectDescriptor_StringList_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_blaze_EnvironmentVariable_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_blaze_EnvironmentVariable_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_EnvironmentVariable_descriptor,
        new java.lang.String[] { "Name", "Value", });
    internal_static_blaze_SpawnInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_blaze_SpawnInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_SpawnInfo_descriptor,
        new java.lang.String[] { "Argument", "Variable", "InputFile", "OutputFile", });
    internal_static_blaze_CppCompileInfo_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_blaze_CppCompileInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_CppCompileInfo_descriptor,
        new java.lang.String[] { "Tool", "CompilerOption", "SourceFile", "OutputFile", "SourcesAndHeaders", "Variable", });
    internal_static_blaze_CppLinkInfo_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_blaze_CppLinkInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_CppLinkInfo_descriptor,
        new java.lang.String[] { "InputFile", "OutputFile", "InterfaceOutputFile", "LinkTargetType", "LinkStaticness", "LinkStamp", "BuildInfoHeaderArtifact", "LinkOpt", });
    internal_static_blaze_JavaCompileInfo_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_blaze_JavaCompileInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_JavaCompileInfo_descriptor,
        new java.lang.String[] { "Outputjar", "Classpath", "Sourcepath", "SourceFile", "JavacOpt", "Processor", "Processorpath", "Bootclasspath", });
    internal_static_blaze_PythonInfo_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_blaze_PythonInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_blaze_PythonInfo_descriptor,
        new java.lang.String[] { "SourceFile", "DepFile", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
