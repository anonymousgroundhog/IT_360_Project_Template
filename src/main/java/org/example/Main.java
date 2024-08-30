package org.example;
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

import javax.xml.transform.Source;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String path = "APK/banner_example.apk";
//        SourceType this_source = new SourceType();
        Path pathToAPK = Paths.get(path);
        AnalysisInputLocation inputLocation = new ApkAnalysisInputLocation(pathToAPK, SourceType.Application);
        JavaView view = new JavaView(inputLocation);

        // get all classes
        Collection<JavaSootClass> classes = view.getClasses();
        for (SootClass sootClass : classes) {
            System.out.println(String.valueOf(sootClass));
            System.out.println(String.valueOf(sootClass.getMethods()));
        }
    }
}