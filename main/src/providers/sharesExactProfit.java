package Code_Questions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sharesExactProfit {
	
	public static void Solution(int[] arr, int [] trans, int arrLen, int transLen){
		//System.out.println("arrLen is:" + arrLen +"transLen is:" + transLen);
		int Profit = 0;
		int currProfit = 0;
		int outStart = 0;
		int outEnd = 0;
		int end=1;
		int start =0 ;
		int minDays = arrLen;
		int i = 0;
        int match = 0;
		while(i<transLen){
			currProfit = 0;
			outStart = 0;
			outEnd = 0;
			end=1;
			start =0 ;
			minDays = arrLen;
			Profit = trans[i];
            match = 0;
			while (start < arrLen){
                currProfit = 0;
				while ( (currProfit < Profit) && end < arrLen){
                                        				

					currProfit = arr[end]-arr[start];
                    //System.out.println("INSIDE Current Profit is:" + currProfit +" -------" +start + "and" + end);
                    end++;
                    
                    		

				}
				//System.out.println("Current Profit is:" +  currProfit + " and Profit = " + Profit +" -------" +start + "and" + end);
				if ( currProfit == Profit)
				{
                    match++;
					if ( minDays > ( end - start)){
						minDays = end - start;
						outStart = start + 1;
						outEnd = end;
					}
				}
				start++;
				end = start + 1;
			}
                if (match == 0){
                    System.out.println("-1");
                }else{
                   System.out.println(outStart + " " + outEnd); 
                }

                
			i++;
			
			
			
		}
		
	}
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int arrSize = in.nextInt();
        int numTransaction = in.nextInt();
        int [] arr = new int[arrSize];
        int [] trans = new int[numTransaction];
        for ( int i = 0; i < arrSize; i++){
        	arr[i] = in.nextInt();
        }
        for ( int i = 0; i < numTransaction; i++){
        	trans[i] = in.nextInt();
        }
        
        Solution(arr, trans, arrSize, numTransaction);
        
    }

}
