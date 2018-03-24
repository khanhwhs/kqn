package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class anagram {
	
	public boolean check(String str1, String str2){
		char[] str = str1.toCharArray();
		StringBuilder sb = new StringBuilder(str2);
		
		if ( str1.length() != str2.length())
		{
			return false;
			
		}else
		{
			for ( char c: str){
				int index = sb.indexOf(String.valueOf(c));
				sb.deleteCharAt(index);
			
			}
			return (sb.length() == 0);
		
		}
		
		
	}
	public boolean check2(String s1, String s2){
		int[] letters = new int[1<<8];
//		System.out.println(letters);
		
		if ( s1.length() != s2.length())
		{
			return false;
			
		}
		for(char c: s1.toCharArray()){
			letters[c]++;
		}
		for(char c: s2.toCharArray()){
			letters[c]--;
		}
		
		for(int i: letters){
			if( i!= 0) return false;
		}
		
		return true;
		
		
		
	}
	public boolean check3(String s1, String s2){
		int[] letters = new int[1<<8];
//		System.out.println(letters);
		
		if ( s1.length() != s2.length())
		{
			return false;
			
		}
		
		int result = 0;
		
		for(char c: s1.toCharArray()){
			result ^= c;
		}
		for(char c: s2.toCharArray()){
			result ^= c;
		}
		if (result == 0){
			System.out.println("CHECK 3 result : " + result);
			return true;
		}
		
		return false;
	
	}
	
	static String nthNumber(int n) {
	    return Integer.toString(n,9);
	}
	
	public static void main(String[] args){
		anagram yea = new anagram();
		
		int a[] = new int[]{2,1,2,1,1,2,3,3,3,1};
        int size = a.length;
//        System.out.println(yea.findCandidate(a, 10));
//		yea.print(7);
//		boolean check = yea.check("abcd","cbad");
//		System.out.println(check);
//		boolean check2 = yea.check2("abcde","cbad");
//		System.out.println(check2);
//		System.out.println(check2);
		
//		boolean check3 = yea.check3("fbcd","cbad");
        String s= "1000322";
        char [] arr = s.toCharArray();
        
        int result = 0;
        for (int i = 0; i < s.length(); i++){
        	result += ( s.charAt(s.length()-i-1) -'0') * Math.pow(10, i);
        }
        System.out.println(result);
        
//		System.out.println('B'-'A');
//        List<List<Character>> results = new ArrayList<>();
//        for ( int i = 0; i < s.length() -1; i++){
//        	System.out.println(s.charAt(i+1)-s.charAt(i));
//        	
//        }
		
		
//		List<String> arrlist = new ArrayList<String>();
//		   arrlist.add("G");
//		   arrlist.add("E");
//		   arrlist.add("F");
//		   arrlist.add("M");
//		   arrlist.add("E");
//		   for (String value : arrlist) {
//			   arrlist.remove("M");
//			   System.out.println("Value = " + value);
//		   } 
		
		
		
	}
	
	int findCandidate(int a[], int size) 
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) 
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
        return a[maj_index];
    }
	
	
	
	public void print(int n){
		int mid = n/2;
		for (int i = 0; i<=mid;i++){
			for(int j = i; j<mid; j++){
				System.out.print(" ");
			}
			for(int l = 0; l<=i*2;l++){
					System.out.print("*");
			}
			System.out.println("");
			
		}
		for (int i = mid-1 ; i>=0;i--){
			for(int j = mid; j>i; j--){
				System.out.print(" ");
			}
			for(int l = 0; l<= i*2;l++){
				System.out.print("*");
			}

			System.out.println("");
			
		}
//		for (int i = 0 ; i<mid ;i++){
//			for(int j = 0; j<=i; j++){
//				System.out.print("s");
//			}
//			for(int l = mid*2; l>i;l--){
//				System.out.print("*");
//			}
//
//			System.out.println("");
//			
//		}
	}

}
