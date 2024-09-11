package org.example;
import org.eclipse.core.internal.resources.Project;
import soot.LocalGenerator;
import soot.RefType;
import soot.Scene;

import soot.jimple.AssignStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import sootup.core.frontend.BodySource;
import sootup.core.frontend.OverridingBodySource;
import sootup.core.frontend.ResolveException;
import sootup.core.frontend.SootClassSource;
import sootup.core.inputlocation.AnalysisInputLocation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.nio.file.Paths;
import java.nio.file.Path;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.*;
//import sootup.core.types.VoidType;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.types.ReferenceType;
import sootup.core.types.VoidType;
import sootup.core.util.printer.JimplePrinter;
import sootup.java.bytecode.inputlocation.ApkAnalysisInputLocation;
import sootup.java.core.JavaSootClass;

import sootup.java.core.JavaSootMethod;
import sootup.java.core.OverridingJavaClassSource;
import sootup.java.core.language.JavaJimple;
import sootup.java.core.views.JavaView;
import sootup.core.jimple.basic.Local;

import java.util.*;

import soot.options.Options;

import javax.annotation.Nonnull;

import static java.lang.reflect.Modifier.*;

public class Main {
    private static final Helper this_Instrumentation_Helper = new Helper();
    public static void main(String[] args) throws IOException {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
//        this_Instrumentation_Helper.prepareSoot("banner_example.apk");
        String path = "APK/banner_example.apk";
        Path pathToAPK = Paths.get(path);
        AnalysisInputLocation inputLocation = new ApkAnalysisInputLocation(pathToAPK, SourceType.Application);

        JavaView view = new JavaView(inputLocation);
        // get all classes
        Collection<JavaSootClass> classes = view.getClasses();
        for (SootClass sootClass : classes) {
            System.out.println("CLASS: "+sootClass.getName());
            System.out.println("\t ClassSource: "+String.valueOf(sootClass.getClassSource()));
            System.out.println("\tSourcePath: "+String.valueOf(sootClass.getClassSource().getClassType()));
            Helper.printClassToJimple(sootClass);
//            if (sootClass.getName().contains("MyActivity")){
//                for (SootMethod sootMethod : sootClass.getMethods()) {
//                    String sootMethodName = sootMethod.getName();
//
//                    if (sootMethodName.contains("<init>") && sootMethod.getParameterTypes().isEmpty()){
//                        System.out.println(String.valueOf(sootClass));
//                        Body thisBody = sootMethod.getBody();
//                        List<Stmt> thisStmts = sootMethod.getBody().getStmts();
//                        System.out.println(String.valueOf(sootMethod));
//                        System.out.println(String.valueOf(thisBody));
//                        System.out.println(String.valueOf(thisStmts));
////                        Local this_local = new Local("x","java.lang.Integer");
//
////                        Local int_local = Jimple.v().newLocal("x", RefType.v("java.lang.Integer"));
////                        AssignStmt IST=Jimple.v().newAssignStmt(int_local,Jimple.v().newStaticFieldRef(Scene.v().getField("<java.lang.integer>").makeRef()));
////                        thisBody.getLocals().add((sootup.core.jimple.basic.Local) int_local);
////                        thisBody.getStmts().addFirst((Stmt) IST);
////                        LocalGenerator this_local_generator = Scene.v().createLocalGenerator();
//
//                    }
//                }
//            }
        }
//
//        JimplePrinter jimplePrinter = new JimplePrinter();
//        FileWriter fileWriter = new FileWriter("example.jimple");
//        PrintWriter printWriter = new PrintWriter(fileWriter);
////        JimpleBody oldBody = Jimple.v().newBody();
////        SootClass thisClass = new SootClass("HelloWorld");
//        Local newLocal = JavaJimple.newLocal("helloWorldLocal", IntType.getInt());
//
////        Body oldBody = new Body;
//        BodySource oldBody = new BodySource() {
//            @Nonnull
//            @Override
//            public Body resolveBody(@Nonnull Iterable<MethodModifier> iterable) throws ResolveException, IOException {
//                return null;
//            }
//
//            @Override
//            public Object resolveAnnotationsDefaultValue() {
//                return null;
//            }
//
//            @Nonnull
//            @Override
//            public MethodSignature getSignature() {
//                return null;
//            }
//        }
//
////        Body newBody = oldBody.withLocals(Collections.singleton(newLocal));
////        new SootMethod("<init>", Arrays.asList(), VoidType.v(), Modifier.PUBLIC);
//        sootup.core.model.MethodModifier thisModifier = new MethodModifier(1);
//
//        soot.SootMethod method = new SootMethod(oldBody, "<init>", List.of(), VoidType.v(), Modifier.PUBLIC);
//        OverridingBodySource newBodySource =
//                new OverridingBodySource(method.getBodySource()).withBody(newBody);
//
//        OverridingJavaClassSource overridingJavaClassSource =
//                new OverridingJavaClassSource(sootClass.getClassSource());
//
//        JavaSootMethod newMethod = method.withOverridingMethodSource(old -> newBodySource);
//
//        OverridingJavaClassSource newClassSource =
//                overridingJavaClassSource.withReplacedMethod(method, newMethod);
//        SootClass newClass = sootClass.withClassSource(newClassSource);
//        jimplePrinter.printTo(thisClass, printWriter);
//        printWriter.close();

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