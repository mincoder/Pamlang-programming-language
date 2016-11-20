package pamlang;
import java.lang.*;
import java.io.*;
public class reader {
  public static String ofname;
  public static void main(String[] args) {
    ofname="compiledpamlang";
    try {
    if(args.length==1) {
      //Setting up files
      File f = new File(args[0]);
      System.out.println("Compiling file " + f.getParent() + "/" + f.getName() + "!");
      String classname = f.getName();
      classname.replace(".conl", "");
      //Establishing writer and reader
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
        String filename = preLine(read.readLine());
        if(filename.contains("name:")) {
          if(isAlpha(Keyslib.DeconstructKeysMessage(filename)[1])) {
            ofname = Keyslib.DeconstructKeysMessage(filename)[1];
          } else {
            System.out.println("Your object name must be alpha nurmerical! Line: " + i++);
            System.exit(0);
          }
        }
      }
      File javafile = new File(f.getParent()+"/"+ofname+".java");
      if(javafile.exists()) {
        javafile.delete();
        javafile.createNewFile();
      } else {
        javafile.createNewFile();
      }
      PrintWriter writer = new PrintWriter(javafile, "UTF-8");
      read = new BufferedReader(new FileReader(f));
      for(int i=0;i<=lines;i++) {
        String impcheck = preLine(read.readLine());
        if(impcheck.contains("imp")) {
          if(!imps.getImp(impcheck).equalsIgnoreCase("error")) {
            writer.println(imps.getImp(impcheck));
          } else {
            System.out.println("Error! Not valid imp! Line: " + i++);
          }
        }
      }

      read = new BufferedReader(new FileReader(f));
      //Starting command compilation
      writer.println("public class " + ofname + " {");
      writer.println("public static void main(String[] args) {");
      lines--;
      for(int i=0;i<=lines;i++) {
        String newcode = read.readLine();
        if(newcode==null) {
          newcode="";
        }
        newcode = preLine(compiler.compileLine(newcode));
        if(!newcode.contains("@Error")) {
          writer.println(newcode);
        } else {
          System.out.println(newcode + i);
          System.exit(0);
        }
      }
      writer.println("}");
      writer.println("}");
      writer.close();
      int exitValue = toJar.createJar(ofname, javafile);
      if(exitValue==0) {
        System.out.println("Compile done!");
      } else {
        System.out.println("Could not compile java code to class make sure application is run as administrator!\n Could also be an error in your code!");
      }
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
