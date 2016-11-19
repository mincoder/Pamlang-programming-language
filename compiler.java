package pamlang;
import pamlang.compiler;

public class compiler {
  public static String compileLine(String command) {
    if(CheckForPre(command)) {
      String header = Keyslib.DeconstructKeysMessage(command)[1];
      switch(header) {
        case: "open":
          command=
        if(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0].equalsIgnoreCase("popup")) {
          command = "JOptionPane.showMessageDialog(null," + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + " + \"\");";
        } else if(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0].equalsIgnoreCase("writeConsole")) {
          command = "System.out.println(" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ");";
        } else {
          command="@Error not valid thing to open! Line: ";
        }
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("text")) {
        command = "String " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
      }  else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("numb")) {
        command = "double " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
      }  else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("var")) {
        command = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0] + " = " + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ";";
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase(";tloop")) {
        String varname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        String times = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
        String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1];
        command = "for(int " + varname + "=0;" + varname+"<" + times + ";" + varname + "++) {" + compileLine(todo);
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase(";bloop")) {
        String todo = Keyslib.DeconstructKeysMessage(command)[1];
        command = "while(true) {" + compileLine(todo);
      }  else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("tloop")) {
        String varname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        String times = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
        String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1];
        command = "for(int " + varname + "=0;" + varname+"<" + times + ";" + varname + "++) " + compileLine(todo) + ";";
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("bloop")) {
        String todo = Keyslib.DeconstructKeysMessage(command)[1];
        command = "while(true) " + compileLine(todo) + ";";
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("doJava")) {
        command = Keyslib.DeconstructKeysMessage(command)[1];
      } else if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("checkif")) {
        String operator = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        String todo = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
        command = "if(" + operator + ") {" + compileLine(todo);
      } else if(command.equalsIgnoreCase("stoploop")) {
        command = "break;";
      } else if(command.equalsIgnoreCase("end")) {
        command = "}";
      } else if(command.equalsIgnoreCase("ig")) {
        command = "";
      }
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
