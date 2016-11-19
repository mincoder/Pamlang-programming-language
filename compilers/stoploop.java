package pamlang.compilers;
import pamlang.*;
public class stoploop implements compilerInterface {
  public String compile(String command) {
    command="break;";
    return command;
  }
}
