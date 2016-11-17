package conlang;

public class mathematics {
  public static String checkVars(String var) {
    if(Keyslib.DeconstructKeysMessage(var)[0].equalsIgnoreCase("add")) {
      try {
          var = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(var)[1])[0] + "+" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(var)[1])[1];
      } catch(Exception e) {
        var = "@Error while adding! Line: ";

      }
    } else if(Keyslib.DeconstructKeysMessage(var)[0].equalsIgnoreCase("multiply")) {
          try {
              var = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(var)[1])[0] + "*" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(var)[1])[1];
          } catch(Exception e) {
            var = "@Error while adding! Line: ";

          }
        }
    return var;
  }
}
