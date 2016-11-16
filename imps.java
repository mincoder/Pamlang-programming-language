public class imps {
  public static String getImp(String imp) {
    switch(imp) {
      case "imp:popup" :
        return "import javax.swing.JOptionPane;";
        break;
      case "imp:timeEvent" :
        return "import java.awt.event.ActionEvent; import javax.swing.Timer;";
        break;
      default:
        return "imp error";
        break;
    }
  }
}
