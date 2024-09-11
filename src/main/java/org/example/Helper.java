package org.example;

import soot.*;
import soot.options.Options;
import sootup.core.model.Body;
import sootup.core.model.SootClass;
import sootup.core.util.printer.JimplePrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Helper {
    public static void printClassToJimple(SootClass sootClassToPrint) throws IOException {

        String cwd=System.getProperty("user.dir");
//        System.out.println("Current directory:"+cwd);
//        System.setProperty("user.dir", cwd+"/sootOutput/");
//        System.out.println("Current directory:"+System.getProperty("user.dir"));
        JimplePrinter jimplePrinter = new JimplePrinter();
        FileWriter fileWriter = new FileWriter(sootClassToPrint.getName()+".jimple");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        jimplePrinter.printTo(sootClassToPrint, printWriter);
        printWriter.close();
//        System.setProperty("user.dir", cwd);
    }
    public static void prepareSoot(String App_Name) {
        soot.G.reset();
        Options.v().set_src_prec(Options.src_prec_apk);
//        Options.v().set_process_dir(Arrays.asList("../../APK/"+folder+"/"+app_name));
        Options.v().set_android_jars("Android/platforms");
        Options.v().set_process_dir(Arrays.asList("APK/"+App_Name));
        Options.v().set_process_multiple_dex(true);
        Options.v().set_whole_program(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().setPhaseOption("cg.spark", "on");
        // option="j";
//        if(option.equals("J") || option.equals("j")){
            Options.v().set_output_format(Options.output_format_jimple);
//        }else{
//            Options.v().set_output_format(Options.output_format_dex);
//        }

        Scene.v().loadNecessaryClasses();
        // Perform the necessary transformations on the scene
        Scene.v().setEntryPoints(Scene.v().getEntryPoints());
        Scene.v().setFastHierarchy(new FastHierarchy());
        // Run the analysis
        PackManager.v().runPacks();
        PackManager.v().writeOutput();
    }

    public static Local Generate_Local(Body this_body, LocalGenerator this_local_generator, String string_this_local){
        boolean contains_local = false;
        Local local_to_return = null;
        for (sootup.core.jimple.basic.Local local : this_body.getLocals()) {
            if (local.getType().toString().equals(string_this_local)) {
                contains_local = true;
                local_to_return = (Local) local;
            }
        }
        if(!contains_local){
            local_to_return = this_local_generator.generateLocal(RefType.v(string_this_local));
        }

        return local_to_return;
    }
}
