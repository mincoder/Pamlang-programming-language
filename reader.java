package conlang;
import java.io.*;
public class reader {
  public static void main(String[] args) {
    try {
    if(args.length==1) {
      //Setting up files
      File f = new File(args[0]);
      System.out.println("Compiling file " + args[0] + "!");
      String name = f.getName();
      name.replace(".cl", "");
      File compile = new File(f.getParent()+"/"+name+".java", "UTF-8");
      if(compile.exists()) {
        compile.createNewFile();
      } else {
        compile.delete();
        compile.createNewFile();
      }
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
        t=read.readLine();
      }
      read.reset();
      //Setting up imps an main file name
      for(int i=0;i<lines;i++) {
        String impcheck = preLine(read.readLine());
        if(!imps.getImp(impcheck).equalsIgnoreCase("imp error")&&impcheck.contains("imp")) {
          writer.println(imps.getImp(impcheck));
        } else {
          System.out.println("Invalid imp! Line: " + i);
          System.exit(0);
        }
      }
      read.reset();
      String ofname="clmain";
      for(int i=0;i<lines;i++) {
        String filename = preLine(read.readLine());
        if(filename.contains("name:")&&isAlpha(Keyslib.DeconstructKeysMessage(filename)[0])) {
          filename = Keyslib.DeconstructKeysMessage(filename)[0];
          ofname = filename;
        } else if(!(isAlpha(Keyslib.DeconstructKeysMessage(filename)[0]))) {
          System.out.println("Your object name must be alpha nurmerical! Line: " + i);
          System.exit(0);
        }
      }
      read.reset();
      //Starting command compilation
      writer.println("public class " + ofname + " {");
      writer.println("public static void main(String[] args) {");
      for(int i=0;i<lines;i++) {
        String newcode = preLine(compiler.compileLine(read.readLine()));
        if(newcode.contains("@Error")) {
          writer.println(newcode);
        } else {
          System.out.println(newcode);
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
