package Code_Questions;

import java.util.ArrayList;

public class AllSubSets {
	public static void main( String [] args){
		int [] arr= {1,2,3};
		ArrayList<Integer> list = new ArrayList<>();

		
		//USING BITMASK
		
		String [] arr1 = {"a","b","c","d","e"};
		int allMasks = (1 << arr1.length);
		
		for( int i = 1; i < allMasks; i++){
			for( int j = 0; j < arr1.length; j++){
				if( (i & (1<<j)) > 0) System.out.print(arr1[j] + " ");
			}
			System.out.println();
		}
	}
	

	
}
