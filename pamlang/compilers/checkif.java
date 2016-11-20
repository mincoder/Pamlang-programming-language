package pamlang.compilers;
import pamlang.*;
public class checkif implements compilerInterface {
  public String compile(String command) {
    String operator = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    command = "if(" + operator + ") {" + compiler.compileLine(todo);
    return command;
  }
}
