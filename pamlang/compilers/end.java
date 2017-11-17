package pamlang.compilers;
import pamlang.*;
public class end implements compilerInterface {
    public String compile(String command,int line) {
        command = "}";
        return command;
    }
}