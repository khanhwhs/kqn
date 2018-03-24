package Code_Questions;

import java.util.ArrayList;
import java.util.List;

//0 1 2 3 4 5 6 7 8
//4,5,6,1,2,3
//
//4,1,2,3

public class BestTimeToBuyStock {
	public static List<Integer> res = new ArrayList<>();
	public static void main ( String [] args){
		int [] stock = {3,3,7,4,23,6,5,3,64,8,54,37,3,7,6,3,7,9,5,57};
		int [] arr = {3,4,7,8,9,3};
		int min = Integer.MAX_VALUE;
		int max = 0;
		for( int i: stock){
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		System.out.println("Buy in at: " + min + " and Sell at: "+ max);
		find(arr,0,arr.length -1);
		System.out.println(res.toString());
	}
	
	
	
	
	//find where the rotation happens
	public static void find(int arr[], int l, int h){
//		int mid = (l + h) /2;
//		if(mid<h && arr[mid] > arr[mid+1]){
//			res.add(mid);
//			res.add(mid+1);
//		}else{
//			if(arr[mid] > arr[l]) find(arr,mid+1,h);
//			else find(arr,l,mid);
//		}
		
		int mid = (l+h) /2;
		if( mid<h && arr[mid] > arr[mid+1]){
			res.add(mid);
			res.add(mid+1);
		}else{
			if(arr[mid] > arr[l]) find(arr,mid+1,h);
			else find(arr,l,mid);
		}
	}

}
