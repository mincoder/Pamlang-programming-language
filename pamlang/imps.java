package pamlang;
public class imps {
  public static String getImp(String imp) {
    switch(imp) {
      case "imp:popup" :
        return "import javax.swing.JOptionPane;";
      case "imp:timeEvent" :
        return "import java.awt.event.ActionEvent; import javax.swing.Timer;";
    }
    return "error";
  }
}
