package pamlang.compilers;
import panglang.*;
public class doJava implements compilerInterface {
  public String compile(String commmand) {
    String todo = Keyslib.DeconstructKeysMessage(command)[1];
    command = "while(true) " + compileLine(todo) + ";";
    return command;
  }
}
