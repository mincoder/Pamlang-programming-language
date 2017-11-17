package pamlang;

import java.nio.file.Paths;

public class imps {
  public static String getImp(String imp) {
    switch(imp) {
      case "imp:popup" :
        return "import javax.swing.JOptionPane;";
      case "imp:timeEvent" :
        return "import java.awt.event.ActionEvent; import javax.swing.Timer;";
      case "imp:file" :
    	return "import java.nio.file;import java.io.*;";
    }
    return "error";
  }
}
