package pamlang.compilers;

import pamlang.Keyslib;
import pamlang.compiler;

public class errhandle {
	
	public static String compile(String command, int line) {
		System.out.println(Keyslib.DeconstructKeysMessage(command)[1]);
		command = "try {" + compiler.compileLine(Keyslib.DeconstructKeysMessage(command)[1], line) + "} catch(Exception e) { System.out.println(\"Error at line:" + line + " Code:  " + command +"\");}";
		return command;
	}
	
}
