package pamlang.compilers;

import pamlang.Keyslib;

public class text {

	public String compile(String command,int line) {
		command = "String " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1],line);
		return command;
	}

}
