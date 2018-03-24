package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInTwoD {
	
	public static void main(String[] args){
		int [][] coins = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{16,17,18,22}};
//		System.out.println(Search(coins,22));
//		System.out.println('b' - 'a');
	    int index = 1;
	    List<Integer> A = new ArrayList<>();
	    A.add(1);
	    A.add(1);
	    A.add(1);
	    A.add(1);
	    A.add(1);
	    A.add(1);
	    A.add(1);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(2);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    A.add(3);
	    
	    int n = A.size();
	    
	    for (int i = 1; i < n; i++) {
	        
	        if (A.get(i).intValue() != A.get(i - 1).intValue()) {
//	            int temp = A.get(index);
//	            A.set(index, A.get(i));
	            index++;
	        }
	    }
	    
	    int ct = 1;
//	    int curr = 0;
//	    int next= 1;
//	    while (curr < A.size() && next < A.size())
//	    {
//	        if (A.get(curr) == A.get(next)){
//	            next++;
//	        }
//	        else{
//	            ct++;
//	            curr = next;
//	            next = next + 1;
//	        }
//	    }
//		 System.out.println(ct);
		 System.out.println(index);
	}
	
	public static boolean Search(int [][] arr, int x){
		if ( arr == null) return false;
		int m = arr.length;
		int n = arr[0].length;
		if (x < arr[0][0] || x > arr[m-1][n-1]) return false;
		for ( int i=0; i< arr.length; i++){
			System.out.println("i is: " + i + "       " + Arrays.toString(arr[i]));
			if (x > arr[i][n-1]) continue;
			else return binSearch(arr[i], x);
		}
		
		return false;
	}
	
	public static boolean binSearch(int [] arr, int x){
		int length = arr.length;
		
		int mid= length/2;
		System.out.println("mid is " + mid + "length is : " + length + "       " + Arrays.toString(arr));
		if ( arr.length == 1 && arr[mid] != x) return false;
		else if ( x > arr[mid]) return binSearch(Arrays.copyOfRange(arr,mid+1,length), x);
		else if ( x < arr[mid]) return binSearch(Arrays.copyOfRange(arr,0,mid), x);
		else if ( x==arr[mid]) return true;
		else return false;
		
	}

}
