package org.example;
import org.eclipse.core.internal.resources.Project;
import soot.LocalGenerator;
import soot.RefType;
import soot.Scene;

import soot.jimple.AssignStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.Jimple;
import sootup.core.inputlocation.AnalysisInputLocation;
import java.nio.file.Paths;
import java.nio.file.Path;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.Body;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.model.SourceType;
import sootup.java.bytecode.inputlocation.ApkAnalysisInputLocation;
import sootup.java.core.JavaSootClass;

import sootup.java.core.views.JavaView;
import sootup.core.jimple.basic.Local;

import java.util.*;

import soot.options.Options;
public class Main {
    private static Helper this_Instrumentation_Helper = new Helper();
    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        this_Instrumentation_Helper.prepareSoot("banner_example.apk");
        String path = "APK/banner_example.apk";
        Path pathToAPK = Paths.get(path);
        AnalysisInputLocation inputLocation = new ApkAnalysisInputLocation(pathToAPK, SourceType.Application);

        JavaView view = new JavaView(inputLocation);

        // get all classes
        Collection<JavaSootClass> classes = view.getClasses();
        for (SootClass sootClass : classes) {
            if (sootClass.getName().contains("MyActivity")){
                for (SootMethod sootMethod : sootClass.getMethods()) {
                    String sootMethodName = sootMethod.getName();

                    if (sootMethodName.contains("<init>") && sootMethod.getParameterTypes().isEmpty()){
                        System.out.println(String.valueOf(sootClass));
                        Body thisBody = sootMethod.getBody();
                        List<Stmt> thisStmts = sootMethod.getBody().getStmts();
                        System.out.println(String.valueOf(sootMethod));
                        System.out.println(String.valueOf(thisBody));
                        System.out.println(String.valueOf(thisStmts));
                        Local this_local = new Local("x","java.lang.Integer");

//                        Local int_local = Jimple.v().newLocal("x", RefType.v("java.lang.Integer"));
//                        AssignStmt IST=Jimple.v().newAssignStmt(int_local,Jimple.v().newStaticFieldRef(Scene.v().getField("<java.lang.integer>").makeRef()));
//                        thisBody.getLocals().add((sootup.core.jimple.basic.Local) int_local);
//                        thisBody.getStmts().addFirst((Stmt) IST);
//                        LocalGenerator this_local_generator = Scene.v().createLocalGenerator();

                    }
                }
            }
        }

//        ApkAnalysisInputLocation inputLocation =
//                new ApkAnalysisInputLocation(pathToAPK, SourceType.Application);
//
//        JavaLanguage language = new JavaLanguage(8);
//
//        Project project = JavaProject.builder(language)
//                        .addInputLocation(inputLocation).build();
//
//        ClassType classType =
//                project.getIdentifierFactory().getClassType("HelloWorld");
//
//        MethodSignature methodSignature =
//                project.getIdentifierFactory().getMethodSignature(
//                                "main", classType, "void",
//                                Collections.singletonList("java.lang.String[]"));
//
//        View view = project.createView();
//
//        SootClass<JavaSootClassSource> sootClass =
//                (SootClass<JavaSootClassSource>) view.getClass(classType).get();
//
//        SootMethod sootMethod =
//                sootClass.getMethod(methodSignature.getSubSignature()).get();
//
//        sootMethod.getBody().getStmts();
    }
}