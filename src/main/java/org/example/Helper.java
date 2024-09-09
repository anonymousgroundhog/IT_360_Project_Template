package org.example;

import soot.FastHierarchy;
import soot.PackManager;
import soot.Scene;
import soot.options.Options;

import java.util.Arrays;

public class Helper {

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
}
