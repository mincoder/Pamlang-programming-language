package pamlang.compilers;

import pamlang.Keyslib;

public class nat {

	public String compile(String command,int line) {
		command = "int " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1],line);
		return null;
	}

}