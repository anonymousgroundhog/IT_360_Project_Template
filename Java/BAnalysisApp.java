import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.expr.JVirtualInvokeExpr;
import sootup.core.jimple.common.stmt.JInvokeStmt;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.views.View;
import sootup.java.bytecode.inputlocation.PathBasedAnalysisInputLocation;
import sootup.java.core.language.JavaJimple;
import sootup.java.core.views.JavaView;

import java.io.*;
import java.util.*;

public class BAnalysisApp {
	public static void main(String[] args) {
		// String apk_file = args[0];
    	// String this_folder = args[3];
    	// String app_name_only = apk_file.replace(".apk","");
    	// String this_hash = args[1];
    	// String option = args[2];
		 Path pathToBinary = Paths.get("APK/");
    	AnalysisInputLocation inputLocation = PathBasedAnalysisInputLocation.create(pathToBinary, null);
	}
}