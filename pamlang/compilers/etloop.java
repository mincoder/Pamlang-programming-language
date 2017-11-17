package pamlang.compilers;

import pamlang.Keyslib;
import pamlang.compiler;

public class etloop {

	public String compile(String command,int line) {
		String varname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        String times = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1];
        command = "for(int " + varname + "=0;" + varname+"<" + times + ";" + varname + "++) {";

		return command;
	}

}
