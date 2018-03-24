package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//using trie
public class AutoComplete {
	private class Node{
		String prefix;
		HashMap<Character, Node> children;
		boolean isWord;
		private Node(String prefix){
			this.prefix = prefix;
			this.children = new HashMap<Character, Node>();
		}
	}
	
	private Node trie;
	private AutoComplete(String [] dict){
		trie = new Node(" ");
		for(String s: dict) insertWord(s);
	}
	
	private void insertWord(String word){
		Node curr= trie;
		for(int i = 0; i < word.length(); i++){
			if(!curr.children.containsKey(word.charAt(i))){
				curr.children.put(word.charAt(i), new Node(word.substring(0,i+1)));
			}
			curr = curr.children.get(word.charAt(i));
			if(i == word.length() -1){
				curr.isWord = true;
			}
				
		}
	}
	
	public List<String> getWordsforPrefix( String prefix){
		List<String> results = new ArrayList<>();
		Node curr=trie;
		for( char c: prefix.toCharArray()){
			if ((curr.children.get(c) == null)){
				return results;
			}else {
				curr =  curr.children.get(c);
			}
		}
		
//		for (Map.Entry<Character, Node> entry: curr.children.entrySet()){
//			
//		}
		getWordsforPrefix(curr, results);
		
		
		return results;
		
	}
	public void getWordsforPrefix(Node n,List<String> results ){
		if(n.isWord) results.add(n.prefix);
		for(Character c: n.children.keySet()){
			getWordsforPrefix(n.children.get(c),results);
		}
			
		
	}
	
	public static void main(String args[]){
		String [] dict = {"oabc", "otac", "abat", "oatt","oagfgfddfg", "oags", "oagse"};
		AutoComplete autoComplete = new AutoComplete(dict);
		List<String> results = autoComplete.getWordsforPrefix("ab");
		
		for( String res:results){
			System.out.println(res);
		}
		
	}

}
