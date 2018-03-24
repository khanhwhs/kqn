package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordGroup {
	public static void main(String [] args){
		String [] words = {"dog","cat", "god","taccc", "fun", "not", "doog"};
		System.out.println(wGroup(words).toString());
	}
	
	public static String key(String word){
		
		String key="";
		boolean [] cache = new boolean[26];
		for (char c: word.toCharArray()){
			cache[c - 'a'] = true;
		}
		
		for(int i = 0; i < 26; i++){
			if(cache[i]) key = key + (char)('a' + i); 
		}
		return key;
	}
	
	public static List<ArrayList<String>> wGroup(String[] words){
		Map<String,ArrayList<Integer>> map = new HashMap<>();
		
		for(int i = 0; i< words.length ; i++){ // O(n)
			String key = key(words[i]); //O(k)
			
			if(map.containsKey(key)){
				map.get(key).add(i);
			} else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(key, list);
			}
		}
		
		List<ArrayList<String>> out = new ArrayList<ArrayList<String>>();
		for(Map.Entry<String,ArrayList<Integer>> entry: map.entrySet()){
			ArrayList<String> temp = new ArrayList<>();
			for(int i: entry.getValue()){
				temp.add(words[i]);
			}
			out.add(temp);
		}
		return out;
		
	}
}
