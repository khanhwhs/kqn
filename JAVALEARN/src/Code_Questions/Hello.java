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

public class Hello {
	public static int divide(int nu, int de) {

	    int temp = 1;
	    int quotient = 0;

	    while (de <= nu) {
	        de <<= 1;
	        
	        temp <<= 1;
	    }

	    
	    while (temp > 1) {
	        de >>= 1;
		    System.out.println(de + " " + temp + " " + nu + " " + quotient);
	        temp >>= 1;

	        if (nu >= de) {
	            nu -= de;
	            //printf("%d %d\n",quotient,temp);
	            quotient += temp;
	        }
	    }
	    System.out.println("qIS " + quotient);
	    return quotient;
	}
	
	public static void removeMapFromChar(HashMap<Character,Integer>patMap, char c)	{
			if(patMap.get(c) == null){
				return;
			}
			else if (patMap.get(c) == 1)
				patMap.remove(c);
			else{
				int count = patMap.get(c) - 1;
				patMap.put(c, count);
			}
	}
	public static void buildMapFromChar(HashMap<Character,Integer>patMap, char c)	{
		if(patMap.get(c) == null)
			patMap.put(c, 1);
		else{
			int count = patMap.get(c) + 1;
			patMap.put(c, count);
		}
}
	
	
	//This problem check all the anagrams that p has a starting an index in s.
	public static ArrayList<Integer> match(String s, String p) {
		HashMap<Character,Integer> patMap = new HashMap<Character,Integer>();
		for (char c : p.toCharArray())
			buildMapFromChar(patMap,c);


		
		HashMap<Character,Integer> tempMap = new HashMap<Character,Integer>();
		for (int i = 0; i < p.length(); i++) {
			buildMapFromChar(tempMap,s.charAt(i));
		}
		
		System.out.println(patMap);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matchCount(patMap, tempMap))
			list.add(0);

		for (int i = p.length(); i < s.length(); i++) {
			removeMapFromChar(tempMap,s.charAt(i - p.length()));
			
		
			buildMapFromChar(tempMap,s.charAt(i));
			
			
			if (matchCount(patMap, tempMap))
				list.add(i - p.length() + 1);
		}

		for (int num : list)
			System.out.print(num + " ");
		return list;
	}

	private static boolean matchCount(HashMap<Character, Integer> patMap, HashMap<Character, Integer> tempMap) {
		return patMap.equals(tempMap);
	}

	public static void main(String[] args) {
		
		long rev = 0;
	    long []a = {2, 2, 3, 5, 2, 2, 6};
	    int maj_index = 0, count = 1;
	    int i;
	    for (i = 1; i < a.length; i++)
	    {
	        if (a[maj_index] == a[i])
	            count++;
	        else
	            count--;
	        if (count == 0)
	        {
	            maj_index = i;
	            count = 1;
	        }
	    }
	    
	    System.out.println(maj_index);
	    
		
//		int ans = removeDuplicates(a);
//		System.out.println(ans);
//		match("BBACDGABBCDA", "ABBCD");
	}
	

	public static int removeDuplicates(ArrayList<Integer> a) {
	    if ( a == null) return 0;
	    int ct = 0;
	    for ( int i =0; i < a.size(); i++){
	        if ((i+1 < a.size()) && a.get(i) == a.get(i+1))
	        {
	        	int j = 2;
	            while ( i+j < a.size() && a.get(i+j) == a.get(i) && i+j+1 < a.size() ){
	                ct++;
	                System.out.println("i: " + i + " ---- a : " + a);
	                j++;  
	                
	            }
	            if ( i+2 < a.size() && i+j < a.size()){
	            a.set(i+2, a.get(i+j));
	            i = i+2;
	            }
	        }
	        
	    }
	    
	    return a.size() - ct;
	}

	
	
	
//
//		public static void main(String args[])	{
//
//			HashMap<Character,Integer> patMap = new HashMap<Character,Integer>();
//	
//			char pat[] = "ABCD".toCharArray();
//	
//			char txt[] = "BACDGABCDA".toCharArray();
//	
//			buildMapFromChar(patMap,pat);
//	
//			for(int i = 0 ; i < txt.length ; i++)	{
//	
//				if(i + pat.length - 1 < txt.length)	{
//		
//					char temp[] = Arrays.copyOfRange(txt, i, i+pat.length);
//			
//					System.out.println("Found:" + temp[0] + temp[3]);
//			
//					HashMap<Character,Integer> tempMap = new HashMap<Character,Integer>();
//			
//					buildMapFromChar(tempMap, temp);
//			
//					if(hashMapEqual(tempMap, patMap))	{
//			
//						System.out.println("Found @:" + i);
//			
//					}
//		
//				}
//	
//			}
//
//		}
//
//		public static void buildMapFromChar(HashMap<Character,Integer>patMap, char c[])	{
//
//			for(int i = 0; i< c.length ; i++){
//	
//				if(patMap.get(c[i]) == null)	{
//	
//					patMap.put(c[i], 1);
//
//				}
//
//				else	{
//
//					int count = patMap.get(c[i]);
//
//					patMap.put(c[i], ++count);
//
//				}
//
//			}
//
//		}
//
//		public static boolean hashMapEqual(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2)	{
//
//			return map1.equals(map2);
//
//			}
	}


	
