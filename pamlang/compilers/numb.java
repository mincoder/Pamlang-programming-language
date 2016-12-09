package pamlang.compilers;

import pamlang.Keyslib;

public class numb {

	public String compile(String command) {
		command = "double " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1]) + ";";
		return null;
	}

}
