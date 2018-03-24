package Code_Questions;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class NoSameAdj {
	public static void main(String [] args){
		String s = "aaavvaaadddd";
		int [] cache = new int [26];
		long start = System.nanoTime();


//		System.out.println(cache[2]);
		for(char c: s.toCharArray()){
			if( cache[c -'a'] > 0) cache[c -'a'] = cache[c -'a'] + 1;
			else cache[c -'a'] = 1;
		}
		int max = 0;
		String sortedS = "";
		for( int i = 0; i<26; i++){ // constant time
			if( cache[i] > 0){
				int j =0;
				while ( j < cache[i]){ //n
					sortedS += (char) (i + 'a');
					j++;
				}
			}
			max = Math.max(cache[i], max);
		}
		
		if( max > s.length()/2) {
			System.out.println("too many identy cal char in one string");
			return;
		}
		String result = calc(s); // n
		System.out.println(result); //O(k2n) = O(n);
		long end = System.nanoTime();

	}
	
	public static String calc (String s){
		
		char [] arr = s.toCharArray();
		String res = "";
		for(int i = 0; i < arr.length /2; i++){
			res+= arr[i];
			res+=arr[arr.length -i-1];
		}
		return res; 
	}

}
