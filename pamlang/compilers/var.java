package pamlang.compilers;

import pamlang.Keyslib;

public class var {

	public String compile(String command) {
		command = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1]) + ";";
		return null;
	}

}
