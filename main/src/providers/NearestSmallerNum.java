package Code_Questions;

import java.util.Stack;

//Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.  
public class NearestSmallerNum {
	public static void main(String [] args){
		int [] arr = {2,6,4,9,6,78,3,1,35,6,7,4};
		Stack<Integer> s = new Stack<>();
		s.push(arr[0]);
		for(int i= 1; i<arr.length; i++){
			while(!s.isEmpty() && s.peek() > arr[i]){
				s.pop();
			}
			if(s.isEmpty()) s.push(arr[i]);
			else{
				int temp = s.peek();
				s.push(arr[i]);
				arr[i] = temp;
			}
		}
		for( int i : arr)
			System.out.print(i + " ");
	}
}
