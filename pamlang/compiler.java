package pamlang;
import pamlang.compilers;

public class compiler {
  public static String compileLine(String command) {
    if(CheckForPre(command)) {
      String header = "";
      try {
        header = Keyslib.DeconstructKeysMessage(command)[1];
      } catch(NullPointerException npe) {
        header=command;
      }
      switch(header) {
        case: "open":
          command=open.compile(command);
          return command;
        case "text":
          command=text.compile(command);
          return command;
        // _TODO_ADD_COMPILER_ command = "String " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
        case "numb":
          command=numb.compile(command);
          return command;
        // _TODO_ADD_COMPILER_ command = "double " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
        case "var":
          command = var.compile(command);
          return command;
        // _TODO_ADD_COMPILER_ command = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
        case "etloop":
          command = etloop.compile(command);
          return command;
        /* _TODO_ADD_COMPILER_ String varname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        String times = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
        String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1];
        command = "for(int " + varname + "=0;" + varname+"<" + times + ";" + varname + "++) {" + compileLine(todo);*/
        case "ebloop":
          command = ebloop.compile(command);
          return command;
        /* _TODO_ADD_COMPILER_ String todo = Keyslib.DeconstructKeysMessage(command)[1];
        command = "while(true) {" + compileLine(todo);*/
        case "tloop":
          command = tloop.compile(command);
          return command;
        case "bloop":
          command = bloop.compile(command);
          return command;
        case "doJava":
          command = doJava.compile(command);
          return command;
        case "checkif":
          command = checkif.compile(command);
          return command;
        case "stoploop":
          command = stoploop.compile(command);
          return command;
        case "end":
          end.compile(command);
          return command;
        case "ig":
          ig.compile(command);
          return command;
      }
      command="@Error not valid command! \n" + command + " Line: ";
    } else {
      command="";
    }
    return command;
  }
  public static boolean CheckForPre(String command) {
    String[] coms = {"name","imp","pub",""};
    for(int i=0;i<coms.length;i++) {
      if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase(coms[i])) {
        return false;
      }
    }
    return true;
  }
}
