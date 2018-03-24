package Code_Questions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class FinMin {
	
// find Min of array decrease then increase
	
	public static void main( String[] args){
		
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int array[] = new int[n];
//        for(int i=0; i < n; i++){
//                array[i] = in.nextInt();  
//                System.out.println(array[i]);
//        }
		int array[] = {120, 10, 9, 7, 6, 47, 50,78,100,};
//		System.out.println(array[0]);
       int maxans = BinSearchMax(array,0, array.length-1);
       System.out.println(maxans);
		return;
	}
	
	public static int BinSearchMax(int[] array, int low, int high){
		int middle = low + (high - low)/2;
		if (low == high){
			return array[low];
		}
		if ((high == low + 1)&&(array[low] >= array[high])){
			return array[high];
			
		}
		if ((high == low + 1)&&(array[low] < array[high])){
			return array[low];
			
		}
		if ((array[middle] < array[middle-1])&& (array[middle] < array[middle+1])){
			return array[middle];
		}
		
		if ((array[middle] < array[middle-1])&& (array[middle] > array[middle+1])){
			
			return BinSearchMax(array, middle + 1, high);
		}else{
			return BinSearchMax(array, low, middle-1);
		}
	
	}
}
