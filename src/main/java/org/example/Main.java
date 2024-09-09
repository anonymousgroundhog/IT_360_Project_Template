package org.example;
import soot.Scene;

import sootup.core.inputlocation.AnalysisInputLocation;
import java.nio.file.Paths;
import java.nio.file.Path;
import sootup.core.jimple.common.stmt.JAssignStmt;
import sootup.core.model.SootClass;
import sootup.core.model.SourceType;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.java.bytecode.inputlocation.ApkAnalysisInputLocation;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.views.JavaView;

import javax.swing.text.html.Option;
import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import soot.options.Options;
public class Main {
    private static Helper this_Instrumentation_Helper = new Helper();
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        this_Instrumentation_Helper.prepareSoot("banner_example.apk");
//        Options.v().set_output_format(Options.output_format_j);
//        Options.v().set_whole_program(true);
//        Options.v().set_allow_phantom_refs(true);
//        Options.v().set_src_prec(Options.src_prec_apk);
//        Options.v().set_process_dir(Arrays.asList("../../APK/Testing"));
//        Options.v().set_process_multiple_dex(true);
//        Options.v().setPhaseOption("cg.spark", "on");

//        Options.v().set_android_jars("../../../Android/platforms");
//        Options.v().set_force_android_jar("Android/platforms");
        String path = "APK/banner_example.apk";
//        Options.v().set_process_dir(Arrays.asList("../../../APK"));
//        Scene.v().loadNecessaryClasses();
//        Scene.v().setEntryPoints(Scene.v().getEntryPoints());
//        SourceType this_source = new SourceType();
        Path pathToAPK = Paths.get(path);
        AnalysisInputLocation inputLocation = new ApkAnalysisInputLocation(pathToAPK, SourceType.Application);

        JavaView view = new JavaView(inputLocation);

        // get all classes
        Collection<JavaSootClass> classes = view.getClasses();
        for (SootClass sootClass : classes) {
            if (sootClass.getName().contains("MyActivity")){
                System.out.println(String.valueOf(sootClass));
                System.out.println(String.valueOf(sootClass.getMethods()));
            }
        }


    }
}