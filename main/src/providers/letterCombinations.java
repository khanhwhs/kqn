package Code_Questions;

import java.util.ArrayList;
import java.util.List;

//abc def ghi
//^   ^   ^

public class letterCombinations {
	public static String [] cache = new String[10];

	
	public static void main( String [] args){
		cache[0] = "";
		cache[1] = "abc";
		cache[2] = "def";
		cache[3] = "ghi";
		cache[4] = "jkl";
		cache[5] = "mno";
		cache[6] = "pqrs";
		cache[7] = "tuv";
		cache[8] = "xyz";
		cache[9] = "";
		List<String> out = new ArrayList<String>();
		findComb("1231","",out);
		System.out.println(out.toString());
		
	}
	//abc def ghi abc
	//^   ^   ^
	public static void findComb(String in, String result, List<String> out){
			if( in.length() <= 0){
				out.add(result);
				return;
			}
			else{
				String letters = cache[Integer.valueOf(in.substring(0, 1))];
				for( int i = 0 ; i< letters.length(); i++){
					findComb(in.substring(1), result + letters.charAt(i),out);
					result = result.substring(0, result.length());
				}
			}

	}
	
	

}









//if(in.length() <= 0){
//out.add(result);
//return;
//}
//else{
//String letters = cache[Integer.valueOf(in.substring(0,1))]; // first number of the current string
//for(int i = 0; i<letters.length(); i++){
//	result += letters.charAt(i);
//	findComb(in.substring(1), result, out);
//	result = result.substring(0,result.length() -1);
//}
//}