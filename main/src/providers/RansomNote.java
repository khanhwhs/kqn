package Code_Questions;

import java.util.HashMap;
import java.util.Map;

//aabnbccac
//   s   e
//
//a:0
//b:1
//c:0
//ct = 0

public class RansomNote {
	public static void main( String [] args){
		String note = "aabnbccac";
		String b = "abcc";
		String mag = "a(3)b(3)c(3)";
		
		String res = shortestMatch(note,b);
		
		System.out.println(res);
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i< mag.length()-1;i+=4){
			if(i%4 ==0) map.put(mag.charAt(i), Character.getNumericValue(mag.charAt(i+2)));
		}
		
		for(char c: note.toCharArray()){
			if(map.get(c) != null && map.get(c) > 0){
				map.put(c, map.get(c) - 1);
			}else {
				System.out.println("Not Match");
				return;
			}
		}
		System.out.println("Match");;
	}
//e
//aabnbccac
//s     
//
//abcc	
//a:1
//b:1
//c:2
//
//ct = 3

	//a:0
	//b:0
	//c:0
	//n:0
	
	
	public static String shortestMatch(String a, String b){
		String res = null;
		int[] bC = new int [26];
		int [] aC = new int[26];
		int ct = 0;
		int smallestL = Integer.MAX_VALUE;
		
		for(char c: b.toCharArray()){
			 bC[c-'a'] = bC[c-'a'] + 1;
		}
		
		
		int s = 0, e = 0;
		
		while( e<a.length()){
			if(aC[a.charAt(e) - 'a'] < bC[a.charAt(e) - 'a']){
				aC[a.charAt(e) - 'a'] = aC[a.charAt(e) - 'a'] +1;
				ct++;
			} else aC[a.charAt(e) - 'a'] = aC[a.charAt(e) - 'a'] +1;
			while( ct== b.length()){
				if(smallestL > (e-s)){
					res = a.substring(s, e+1);
				}
				if(aC[a.charAt(s) - 'a'] > bC[a.charAt(s) - 'a']){
					aC[a.charAt(s) - 'a'] = aC[a.charAt(s) - 'a'] -1;
					s++;
				}else if(aC[a.charAt(s) - 'a'] == bC[a.charAt(s) - 'a']){
					aC[a.charAt(s) - 'a'] = aC[a.charAt(s) - 'a'] -1;
					s++;
					ct--;
				}
			
			}
			e++;
			
		}
		
		return res;
		
		
	}
	
}
