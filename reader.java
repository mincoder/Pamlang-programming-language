

import java.io.*;

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
      //Preanalasys on file
      BufferedReader linecalc = read;
      int lines = 0;
      while (linecalc.readLine() != null) lines++;
      linecalc.close();
      //Setting up defaults
      for(int i=0;i<lines;i++) {
        String impcheck = preLine(read.nextLine());
        if(impcheck.contains("imp")) {
        }
      }
      writer.println("");
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
