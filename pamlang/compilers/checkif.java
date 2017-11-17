package pamlang.compilers;
import pamlang.*;
public class checkif implements compilerInterface {
  public String compile(String command,int line) {
    String operator = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    command = "if(" + operator + ") {" + compiler.compileLine(todo,line);
    return command;
  }
}
