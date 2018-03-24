package Code_Questions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class FinMax {
	
// Find max on array increase then decrease
	
	public static void main( String[] args){
		
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int array[] = new int[n];
//        for(int i=0; i < n; i++){
//                array[i] = in.nextInt();  
//                System.out.println(array[i]);
//        }
		int array[] = {1, 3, 47, 50,78,100, 120, 10, 9, 7, 6};
//		System.out.println(array[0]);
       int maxans = BinSearchMax(array,0, array.length-1);
       System.out.println(maxans);
		return;
	}
	
	public static int BinSearchMax(int[] array, int low, int high){
		int middle = low + (high - low)/2;
		// if only one element in array
		if (low == high){
			return array[low];
		}
		// there's only 2 values in the array and array[low] is higher
		if ((high == low + 1)&&(array[low] >= array[high])){
			return array[low];
			
		} // there's only 2 values in the array
		if ((high == low + 1)&&(array[low] < array[high])){
			return array[high];
			
		}
		// if the mid value is bigger than both value on left and right
		if ((array[middle] > array[middle-1])&& (array[middle] > array[middle+1])){
			return array[middle];
		}
		
		// if mid value is less than the value on the left and higher than value on the right
		// this means the max value is on the left, go bin search there
		if ((array[middle] < array[middle-1])&& (array[middle] > array[middle+1])){
			return BinSearchMax(array, low, middle-1);
		}else{
			return BinSearchMax(array, middle + 1, high);
		}
	
	}
}
