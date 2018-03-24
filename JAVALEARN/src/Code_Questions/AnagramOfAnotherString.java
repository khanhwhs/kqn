package Code_Questions;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class AnagramOfAnotherString {
	
//	public static void removeMapFromChar(HashMap<Character,Integer>patMap, char c)	{
//			if(patMap.get(c) == null){
//				return;
//			}
//			else if (patMap.get(c) == 1)
//				patMap.remove(c);
//			else{
//				int count = patMap.get(c) - 1;
//				patMap.put(c, count);
//			}
//	}
//	public static void buildMapFromChar(HashMap<Integer, String> mGHM, char c)	{
//		if(mGHM.get(c) == null)
//			mGHM.put(c, 1);
//		else{
//			int count = mGHM.get(c) + 1;
//			mGHM.put(c, count);
//		}
//	}
//	
//    public boolean canConstruct(String ransomNote, String magazine) {
//        if (ransomNote == null && magazine ==null) return true;
//        if (ransomNote.length() == 0 && magazine.length() ==0) return true;
//        HashMap<Integer, String> mGHM = new HashMap<Integer, String>();
//
//        for ( int j=0; j < magazine.length() ; j++)
//        {
//            buildMapFromChar(mGHM ,magazine.charAt(j));
//        }
//        
//        for ( int i=0; i < ransomNote.length() ; i++)
//        {
//            if (mGHM.ContainsKey(ransomNote.charAt(j))){
//                removeMapFromChar(mGHM,ransomNote.charAt(j));
//            }else return false;
//        }
//        return true;
//        
//    }
//	
//	
//	public static ArrayList<Integer> match(String s, String p) {
//		HashMap<Character,Integer> patMap = new HashMap<Character,Integer>();
//		for (char c : p.toCharArray())
//			buildMapFromChar(patMap,c);
//
//
//		
//		HashMap<Character,Integer> tempMap = new HashMap<Character,Integer>();
//		for (int i = 0; i < p.length(); i++) {
//			buildMapFromChar(tempMap,s.charAt(i));
//		}
//		
//		System.out.println(patMap);
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		if (matchCount(patMap, tempMap))
//			list.add(0);
//
//		for (int i = p.length(); i < s.length(); i++) {
//			//tc[s.charAt(i - p.length())]--;
//			removeMapFromChar(tempMap,s.charAt(i - p.length()));
//			
//		
//			//tc[s.charAt(i)]++;
//			buildMapFromChar(tempMap,s.charAt(i));
//			
//			
//			if (matchCount(patMap, tempMap))
//				list.add(i - p.length() + 1);
//		}
//
//		for (int num : list)
//			System.out.print(num + " ");
//		return list;
//	}
//
//	private static boolean matchCount(HashMap<Character, Integer> patMap, HashMap<Character, Integer> tempMap) {
//		return patMap.equals(tempMap);
//	}
	public static ArrayList<Integer> indexes = new ArrayList<Integer>();
	public static void main(String[] args) {
//		       0123456789
		match("bbccdgcbbcda", "cbbcd");
			         
		System.out.println(indexes.toString());
	}
	
	public static void match(String hay,String needle){
		int[] hC = new int[26];
		int[] nC = new int[26];
		for(char c: needle.toCharArray()){
			if(nC[c-'a'] > 0) nC[c-'a'] = nC[c-'a'] +1;
			else nC[c-'a'] = 1;
			
		}
		
		
		for(char c: hay.substring(0, needle.length()).toCharArray()){
			if(hC[c-'a'] > 0) hC[c-'a'] = hC[c-'a'] +1;
			else hC[c-'a'] = 1;
		}
		
		if(checkAna(nC,hC)) indexes.add(0);
		
		for(int i = needle.length(); i < hay.length() ; i++){
			if(hC[hay.charAt(i-needle.length()) - 'a'] > 1) hC[hay.charAt(i-needle.length()) - 'a'] = hC[hay.charAt(i-needle.length()) - 'a'] - 1;
			else hC[hay.charAt(i-needle.length()) - 'a'] = 0;
			if(hC[hay.charAt(i)-'a'] > 0) hC[hay.charAt(i)-'a'] = hC[hay.charAt(i)-'a'] +1;
			else hC[hay.charAt(i)-'a'] = +1;
			if(checkAna(nC,hC)) indexes.add(i-needle.length()+1);
			printH(nC, hC);
			System.out.println();
			
			
		}
				
		
		

	}
	
	public static boolean checkAna(int[] nC, int[] hC){
		for(int i = 0; i < 26; i++){
//			System.out.print(hC[i]);
			if(nC[i] != hC[i]) return false;
		}
		return true;
	}
	
	public static void printH(int[] nC, int[] hC){
		for(int i = 0; i < 26; i++){
			System.out.print(hC[i]);
		}
		System.out.println();
		for(int i = 0; i < 26; i++){
			System.out.print(nC[i]);
		}
		System.out.println();
	}

	
	
	


	}


	
