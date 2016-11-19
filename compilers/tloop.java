package pamlang.compilers;

import pamlang.*;

public class tloop implements compilerInterface {
  public String compile(String command) {
    String varname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    String times = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
    String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1];
    command = "for(int " + varname + "=0;" + varname+"<" + times + ";" + varname + "++) " + compiler.compileLine(todo) + ";";
    return command;
  }
}
