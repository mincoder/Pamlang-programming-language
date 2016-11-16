package conlang;
import java.io.*;
public class reader {
  public static void main(String[] args) {
    try {
    if(args.length==1) {
      //Setting up files
      File f = new File(args[0]);
      System.out.println("Compiling file " + f.getParent() + "/" + f.getName() + "!");
      String name = f.getName();
      name.replace(".conl", "");
      /*File compile = new File(f.getParent()+"/"+name+".java", "UTF-8");
      if(compile.exists()) {
        compile.delete();
        compile.createNewFile();
      } else {
        compile.mkdir();
        compile.createNewFile();
      }*/
      //Establishing writer and reader
      PrintWriter writer = new PrintWriter(f.getParent()+"/"+name+".java", "UTF-8");
      BufferedReader read = new BufferedReader(new FileReader(f));
      //Preanalasys on file
      int lines = 0;
      String t = read.readLine();
      while (t != null) {
        if(t.equalsIgnoreCase("€")) {
          t=null;
        } else {
          t=read.readLine();
        }
        lines++;
      }
      lines--;
      read = new BufferedReader(new FileReader(f));
      //Setting up imps an main file name
      for(int i=0;i<=lines;i++) {
        String impcheck = preLine(read.readLine());
        if(impcheck.contains("imp")) {
          if(!imps.getImp(impcheck).equalsIgnoreCase("error")) {
            writer.println(imps.getImp(impcheck));
          } else {
            System.out.println("Error! Not valid imp! Line: " + lines);
          }
        }
      }
      read = new BufferedReader(new FileReader(f));
      String ofname="clmain";
      for(int i=0;i<=lines;i++) {
        String filename = preLine(read.readLine());
        if(filename.contains("name:")&&isAlpha(Keyslib.DeconstructKeysMessage(filename)[0])) {
          filename = Keyslib.DeconstructKeysMessage(filename)[0];
          ofname = filename;
        } else if(!(isAlpha(Keyslib.DeconstructKeysMessage(filename)[0]))) {
          System.out.println("Your object name must be alpha nurmerical! Line: " + i);
          System.exit(0);
        }
      }
      read = new BufferedReader(new FileReader(f));
      //Starting command compilation
      writer.println("public class " + ofname + " {");
      writer.println("public static void main(String[] args) {");
      for(int i=0;i<=lines;i++) {
        String newcode = preLine(compiler.compileLine(read.readLine()));
        System.out.println(newcode + " : " +lines);
        if(!newcode.contains("@Error")) {
          writer.println(newcode);
        } else {
          System.out.println(newcode + i);
        }
      }
      writer.println("}");
      writer.println("}");
      writer.close();
    } else {
      System.out.println("Compiler must only have one argument which is the path to the file!");
    }
  } catch(Exception e) {
    System.out.println("Internal compiling error");
    e.printStackTrace();
  }
  }

  public static String preLine(String line) {
    line.replace("  ", "");
    line.replace(" ", "");
    return line;
  }
    //File f = new File(args[0]);
    //System.out.println(f.getName() + " : " + f.getParent());
  public static boolean isAlpha(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return false;
        }
    }

    return true;
  }
}
