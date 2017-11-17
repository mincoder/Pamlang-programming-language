package pamlang.compilers;
import pamlang.*;
public class bloop {
  public String compile(String command,int line) {
    String todo = Keyslib.DeconstructKeysMessage(command)[1];
    command = "while(true) " + compiler.compileLine(todo,line);
    return command;
  }
}
