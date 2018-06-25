// package Code_Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    
    private int mem[][];
	private ArrayList<ArrayList<Integer>> A;
	
	public static void main(String[] args) {
		String s = "   ";
		StringBuilder sb = new StringBuilder();
		int k = 0;
		int m = 0;
        
        for(int i = s.length() -1 ; i>=0; i--){
			// System.out.println( "i = "+ i + "   k is :" + k + " current sb: " + sb.toString());
            if(s.charAt(i) == ' '){
				sb.append(s.charAt(i));
				m = k+1;
            }else{
                sb.insert(m,s.charAt(i));
            }
            k++;
        }
        
        System.out.println(reverseWords(s)) ;
	}

	public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() == 0 || s == null)
            return sb.toString();
        String[] tmp = s.split("\\s{1,}");
        for(int i = tmp.length-1; i>=0; i--) {
            sb.append(tmp[i] + " ");
        }
        return sb.toString().trim();
    }
    
	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
	    int m, n;
	    
	    if (A == null || A.size() == 0 || A.get(0).size() == 0)
	        return 0;
	    
	    m = A.size();
	    n = A.get(0).size();
	    
	    mem = new int[m][n];
	    
	    for (int i = 0; i < m; i++)
	        Arrays.fill(mem[i], Integer.MAX_VALUE);
	    System.out.println(mem);
	        
	    mem[0][0] = A.get(0).get(0);
	    
	    this.A = A;
	    rec(m - 1, n - 1);
	    
	    return mem[m - 1][n - 1];
	    
	}
	
	public int rec(int i, int j) {
	    
	    if (i < 0 || j < 0)
	        return Integer.MAX_VALUE;
	    
	    if (mem[i][j] != Integer.MAX_VALUE)
	        return mem[i][j];
	    
	    int res = rec(i - 1, j);
	    res = Math.min(rec(i, j - 1), res);
	    
	    mem[i][j] = res + A.get(i).get(j);
	    
	    return mem[i][j];
	    
	}
	
}
