package pamlang.compilers;

import pamlang.*;

public class doJava implements compilerInterface {
  public String compile(String command,int line) {
    String todo = Keyslib.DeconstructKeysMessage(command)[1];
    command = "while(true) " + compiler.compileLine(todo,line);
    return command;
  }
}
