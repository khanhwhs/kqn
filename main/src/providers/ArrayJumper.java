// package Code_Questions;

public class ArrayJumper {
	public static void main( String [] args){
					    
		int [] arr2 = {3, 1, 0, 1, 1, 1, 1, 1, 1, 8, 9};	            	

		int maxR = arr2[0];
		int jump = 1;
		int step = arr2[0];
		
//		for( int i = 1; i < arr2.length; i++){
//			if(i >= arr2.length) {
//				break;
//			}
//			
//			maxR = Math.max(maxR, i + arr2[i]);
//			step--;
//			if( step == 0){
//				jump++;
//				step = maxR -i;
//			}
//		}
//		
//		System.out.println(jump);
		maxR = 0;
		jump = 0;
		step = 0;
		int i = 0;
		
		while ( i < arr2.length){
			if( i > maxR){
				jump = 0;
				break;
				
			}
			
			if( i > step){
				jump++;
				step = maxR;
			}
			
			maxR = Math.max(maxR, i + arr2[i]);
			i++;
		}
		System.out.println(jump);
		
		
		
		
		// Find an element in a rotated sorted Array
		int [] arr = {6,7,8,8,9,10,3,4,5};
						
		int t = 5;
		int l = 0;
		int h = arr.length-1;
		int middle = (l+h)/2;
		int ans = -1;
		
//		System.out.println(bSC(arr,l,h,t));
		
					  
	}
	
//	123456
//	l mh
	public static int bSC(int []arr, int l, int h, int t){
		int mid = (l+h)/2;
		if(arr[mid] >= arr[l]){
			if(t <= arr[mid] && t >= arr[l]) {
				return bS(arr,l,mid,t);
			}else
			{
				return bSC(arr, mid+1,h, t);
			}
			
		}
		else if ( arr[mid] <= arr[h]){
			if(t <= arr[h] && t >= arr[mid]) {
				return bS(arr,mid,h,t);
			}else
			{
				return bSC(arr, l,mid, t);
			}
		}
		return mid;
	}
	
	public static int bS(int []arr, int l, int h, int t){
		int mid = (l+h)/2;
		if(arr[mid] == t) return mid;
		if(arr[mid] >= t) return bS( arr,l, mid, t);
		else return bS(arr, mid + 1,h,t);
	}
	
	
}
