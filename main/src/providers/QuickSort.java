package Code_Questions;

public class QuickSort {
	private void qs(int[] arr, int low, int high){
		int i = low;
		int j = high;
		int p = (i + (j-i))/2;
		while( i<=j){
			while(arr[i] < arr[p]) i++;
			while(arr[j]> arr[p]) j--;
			if(i<=j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
			
		}
		if(high > i) qs(arr,i,high);
		if( low < j) qs(arr,low,j);
		for( int n : arr){
			System.out.print(n + " , ");
		}
		System.out.println("--------------");

		
	}
	public static void main(String args[]){
		int [] arr = {32,11,24,2,5,3,8,4};
		
		QuickSort qs = new QuickSort();
		qs.qs(arr, 0, arr.length -1);
		for( int i : arr){
			System.out.println(i);
		}
	}

}
