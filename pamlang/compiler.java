package pamlang;

import pamlang.compilers.*;

public class compiler {
  public static String compileLine(String command,int line) {
    if(CheckForPre(command,line)) {
      String header = "";
      try {
        header = Keyslib.DeconstructKeysMessage(command)[0];
      } catch(NullPointerException npe) {
        header=command;
      }
      switch(header) {
        case "open":
          command=new open().compile(command,line);
          return command+";";
        case "text":
          command=((text) new text()).compile(command,line);
          return command+";";
        case "numb":
          command=new numb().compile(command,line);
          return command+";";
        case "var":
          command = new var().compile(command,line);
          return command+";";
        case "etloop":
          command = new etloop().compile(command,line);
          return command+"";
        case "tloop":
          command = new tloop().compile(command,line);
          return command+";";
        case "bloop":
          command = new bloop().compile(command,line);
          return command+";";
        case "doJava":
          command = new doJava().compile(command,line);
          return command+";";
        case "checkif":
          command = new checkif().compile(command,line);
          return command+";";
        case "stoploop":
          command = new stoploop().compile(command,line);
          return command+";";
        case "end":
          return "}";
        case "ig":
          command = new ig().compile(command,line);
          return command+";";
        case "$":
          return "";
        case "nat":
          command = new nat().compile(command, line)+";";
          return command;
        case "errhandle":
          command = errhandle.compile(command, line);
      }
      command="Err: @Error not valid command! Code: " + command + " Line: "+line;
    } else {
      command="";
    }
    return command;
  }
  public static boolean CheckForPre(String command,int line) {
	try {
    String[] coms = {"name","imp","pub",""};
    for(int i=0;i<coms.length;i++) {
      if(Keyslib.DeconstructKeysMessage(command)[0].equalsIgnoreCase(coms[i])) {
        return false;
      }
    }
    return true;
	} catch(Exception e) {
		System.out.println("Unknow error at line:"+line);
		return false;
	}
  }
}
