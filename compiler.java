package conlang;

public class compiler {
  public static String compileLine(String command) {
    //if(!command.isEmptyorNull()) {
      if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase("open")) {
        if(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[0])[0].equalsIgnoreCase("popup")) {
          command = "JOptionPane.showMessageDialog(null,\"" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[0])[1] + "\")";
        } else {
          command="@Error not valid thing to open! Line: ";
        }
      } else {
        command="@Error not valid command! Line: ";
      }
      return command;
    }
  //}
}
