package conlang;
import java.lang.*;
import java.io.*;

public class toJar {
  public static int createJar(String ofname, File javafile) throws IOException, InterruptedException{
    Runtime rt = Runtime.getRuntime();
    Process pr = rt.exec("javac " + javafile.getParent()+"/"+ofname+".java");
    pr.waitFor();
    File f = new File(javafile.getParent()+"/Manifest.txt");
    int exit = pr.exitValue();
    if(f.exists()) {
      f.delete();
      f.createNewFile();
    } else {
      f.createNewFile();
    }
    PrintWriter pw = new PrintWriter(f, "UTF-8");
    pw.println("Manifest-Version: 1.0");
    pw.println("Class-Path: .");
    pw.println("Main-Class: " + ofname + ".class");
    pw.close();
    Process pr2 = rt.exec("jar -cfe " +javafile.getParent() + "/"+ ofname + ".jar " + ofname +" -C " + javafile.getParent() + " " + ofname + ".class");
    pr2.waitFor();
    File compiledversion = new File(javafile.getParent()+"/"+ofname+".class");
    javafile.delete();
    f.delete();
    compiledversion.delete();
    return exit;
  }
}
