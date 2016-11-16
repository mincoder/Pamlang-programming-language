public class compiler {
  public String compileLine(String command) {
    if(Keyslib.DeconstructKeysMesssage(command)[0].equalsIgnoreCase("open")) {
      if(Keyslib.DeconstructKeysMesssage(Keyslib.DeconstructKeysMesssage(command)[0])[0].equalsIgnoreCase("popup")) {
        command = "JOptionPane.showMessageDialog(null,\"" + Keyslib.DeconstructKeysMesssage(Keyslib.DeconstructKeysMesssage(command)[0])[1] + "\")";
      } else {
        command="@Error not valid thing to open! Line: ";
      }
    } else {
      command="@Error not valid command! Line: ";
    }
    return command;
  }
}
