package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBrealk {
	
	public static void main( String args[]){
		List<String> dict = new ArrayList<String>();
		dict.add("a");
		dict.add("at");
		dict.add("amazon");
		dict.add("build");
		dict.add("building");
		
		System.out.println(wb("atamazonbuild", dict));
		System.out.println(map.toString());
	}
	public static Map<String, String> map = new HashMap<String, String>();
	
	public static String wb(String s, List<String> dict){
			if( dict.contains(s) ) return s;
			if(map.containsKey(s)) return map.get(s);
			for( int i = 1; i<s.length(); i++){
				String pre = s.substring(0,i);
				if( dict.contains(pre)){
					String suf = wb(s.substring(i), dict);
					map.put(s, pre+ " "+ suf);
					if(suf != null) return pre+ " "+ suf;
				}
			}
			map.put(s, null);
			return null;
		
	}

}















//if (dict.contains(s)) return s;
//if(map.containsKey(s)) return map.get(s);
//for(int i = 1; i<s.length(); i++){
//	String p= s.substring(0, i);
//	if( dict.contains(p)){
//		String su = wb(s.substring(i),dict);
//		map.put(s, p + " " + su);
//		if(su != null) return( p + " " + su);
//		
//	}
//	
//}
//	
//map.put(s, null);
//return null;
//			wb("atamazonbuilding")
//a	wb("tamazonbuilding")	at	wb("amazonbuilding")
//							amazon wb("building")

