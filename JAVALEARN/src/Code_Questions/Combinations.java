package Code_Questions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	static void Combination(String str, StringBuffer output,int nextAllowedLetter){
		if (nextAllowedLetter == str.length()){
			return;
		}else
		{
			for(int curr=nextAllowedLetter; curr < str.length(); curr++){
				output.append(str.charAt(curr));
				System.out.println(output);
				Combination(str,output,curr+1);
				output.deleteCharAt(output.length() - 1 );
				
			}
			
			
		}
		
	}
	
	static void Combination(String prefix, String str){
//		System.out.println("PREFIX : " + prefix + "          STR : " +  str);
		if ( str.length() > 0){
			System.out.println(prefix + str.charAt(0));
			Combination(prefix + str.charAt(0), str.substring(1));
			Combination(prefix,str.substring(1));
		}
	}
	
//	"abc" 
//	
//	a
//	ab
//	abc
//	ac
//	.
//	.
	
//	C("","abc")
//	p(""+"a")
//	C("", "bc")
//	p(""+"b")
//	C("b", "c")
//	p("b" + "c")


								//p("a" + "c")
								//p("ab" + "c")
	
	public static void main(String[] args){
		
		String str = "abc";
//		int length = str.length();
//		StringBuffer output = new StringBuffer(length);
//		Combination(length,str,output,0);
//		Combination("",str);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4);
		arr.add(15);
		arr.add(20);
		arr.add(60);
		arr.add(75);
		arr.add(80);
		arr.add(100);
		arr.add(110);
		arr.add(120);
		
		ArrayList<Integer> result = func(arr);
		System.out.println(result);
		
		
		
	}
	
	public static ArrayList<Integer> func(ArrayList<Integer> arr){
	    int size = arr.get(0);
	    arr.remove(arr.get(0));
	    if ( size != (arr.size() / 2) || (arr.size() > (size*2))) System.out.println("ERROR");
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for( int i = 0; i < arr.size() -1;){
	    	System.out.println(arr);
	        int temp = arr.get(0);
	        if ( temp == (0.75 * arr.get(i+1))) {
	            result.add(arr.get(0));
	            arr.remove(arr.get(0));
	            arr.remove(arr.get(i));
	            i = 0;
	        } else i++;
	        
	    }
	    System.out.println("result.size() :   "  + result.size() );
	    if ( result.size() == size) return result;
	    else System.out.println("ERROR");
	    return null;
	    
	}  
	
	

}
