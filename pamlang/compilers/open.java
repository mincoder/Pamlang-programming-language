package pamlang.compilers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Random;

import pamlang.*;

public class open implements compilerInterface {
	
  /* NOT NEEDED public boolean shouldCompile(String command) {
    boolean accept;
    return true;
  }*/

  public String compile(String command,int line) {
	String tw = new Random().nextInt()+"op";
    String header = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    switch(header) {
      case "popup":
        command = "JOptionPane.showMessageDialog(null," + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ")";
        return command;
      case "writeConsole":
        command = "System.out.println(" + Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1] + ")";
        return command;
     // case "readFile":
    	//command = "Files.readAllLines(Paths.get(\""+ new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0],line) +"\")).get(" + new value().compile(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1],line) +")";
      case "fileLength":
        String linesname = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
    	String file = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
    	command = "BufferedReader read = new BufferedReader(new FileReader(new File("+file+")));int "+linesname+" = 0;String t = read.readLine();while (t != null) {t=read.readLine();"+linesname+"++;}"+linesname+"--;read=null";
    	return command;
      case "readLine":
       String linetoread = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[0];
       String assign = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[0];
       String filepath = Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(Keyslib.DeconstructKeysMessage(command)[1])[1])[1];
       command = "BufferedReader read = new BufferedReader(new FileReader(new File("+filepath+")));for(int i=0;i<("+linetoread+"-1);i++) {read.readLine();}"+assign+"=read.readLine();read=null";
       //command = assign + "=readLine("+filepath+","+linetoread+")";
       return command;
    }
    return "@Error Not available open command Line: ";
  }
}
