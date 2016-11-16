

import java.io.*;
import imps;
import Keyslib;

public class reader {
  public static void main(String[] args) {
    if(args.length==1) {
      //Setting up files
      File f = new File(args[0]);
      System.out.println("Compiling file " + args[0] + "!");
      String name = g.getName();
      name.replace(".cl", "")
      File compile = new File();
      //Establishing writer and reader
      PrintWriter writer = new PrintWriter(f.getParent()+"/"+name+".java", "UTF-8");
      BufferedReader read = new BufferedReader(new FileReader(f));
      read.mark(0);
      //Preanalasys on file
      int lines = 0;
      String t = read.readLine();
      while (t != null) {
        if(t.equalsIgnoreCase("€")) break;
        lines++;
        t=readLine();
      }
      read.reset();
      //Setting up defaults
      for(int i=0;i<lines;i++) {
        String impcheck = preLine(read.nextLine());
        if(!imps.getImp(impcheck).equalsIgnoreCase("imp error")&&impcheck.contains("imp")) {
          writer.println(imps.getImp(impcheck));
        } else {
          System.out.println("Invalid imp! Line: " + i);
        }
      }
      read.reset();
      for(int i=0;i<lines;i++) {
        String name = preLine(read.nextLine());
        String ofname="clmain";
        if(name.contains("name:")) {
          name = Keyslib.DeconstructKeysMesssage(name)[];
          ofname = name;
        }
      }
      writer.println("public class " + ofname + " {");
      writer.println("")
    }

    public String preLine(String line) {
      line.replace("  ", "");
      line.replace(" ", "");
      return line;
    }
    //File f = new File(args[0]);
    //System.out.println(f.getName() + " : " + f.getParent());
  }

}
