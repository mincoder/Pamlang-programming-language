package pamlang.compilers;
import pamlang.*;
public class bloop implements compilerInterface {
  public String compile(String command) {
    String todo = Keyslib.DeconstructKeysMessage(command)[1];
    command = "while(true) " + compiler.compileLine(todo) + ";";
    return command;
  }
}
