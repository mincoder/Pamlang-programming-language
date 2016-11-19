package pamlang.compilers;

public class open implements expression {
  /* NOT NEEDED public boolean shouldCompile(String command) {
    boolean accept;
    return true;
  }*/

  public String compile(String command) {
    String header = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    switch(header) {
      case "popup":
        command = "JOptionPane.showMessageDialog(null," + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + " + \"\");";
        return command;
      case "writeConsole":
        command = "System.out.println(" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ");";
        return command;
    }
    return "@Error Not available open command Line: ";
  }
}
