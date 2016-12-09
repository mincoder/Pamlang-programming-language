package pamlang.compilers;

import pamlang.Keyslib;
import pamlang.compiler;

public class value implements compilerInterface{

	public String compile(String command) {
		try {
		if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase(".")) {
			return compiler.compileLine(Keyslib.DeconstructKeysMessage(command)[1]);
		}
		} catch(Exception e) {
		}
		return command;
	}
}
