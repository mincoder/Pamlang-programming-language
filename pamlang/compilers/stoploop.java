package pamlang.compilers;
import pamlang.*;
public class stoploop implements compilerInterface {
  public String compile(String command,int line) {
    command="break";
    return command;
  }
}
