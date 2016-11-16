package conlang;
public class Keyslib {

	public static String[] DeconstructKeysMessage(String s) {
		int j = 0;
		String[] re = new String[2];
		for(int i = 0; i < s.length(); i++) {
			int p = i + 1;
			String l = s.substring(i,p);
			if(l.equals(":")) {
				re[0] = s.substring(0,i);
				j = i + 1;
				break;
			}
		}
		re[1] = s.substring(j, s.length());
		return re;
	}

	public static String ContructKeysMessage(String a, String b) {
		return a + ":" + b;
	}

}
