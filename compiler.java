package conlang;
public class compiler {
  public static String compileLine(String command) {
    if(CheckForPre(command)) {
      if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("open")) {
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
      } else {
        command="@Error not valid command! Line: ";
      }
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
