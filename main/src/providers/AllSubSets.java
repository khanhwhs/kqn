// package Code_Questions;

import java.util.ArrayList;

public class AllSubSets {
	public static void main( String [] args){
		int [] arr= {1,2,3};
		ArrayList<Integer> list = new ArrayList<>();

		
		//USING BITMASK
		
		String [] arr1 = {"a","b","c"};
		int allMasks = (1 << arr1.length);
		
		permutations(arr1,0,arr1.length);


		// for( int i = 1; i< allMasks; i++){
		// 	for ( int j = 0; j < arr1.length; j++){
		// 		if((i & (1<<j)) >0) System.out.print(arr1[j] + " ");
		// 	}
		// 	System.out.println();
		// }

		// combinations(arr1,new String[arr1.length],0);
		// combinations(arr1,new StringBuffer(),0);
		// combine("abc",new StringBuffer(),0);
		
	}

	public static void combinations(String [] arr, String [] out, int index){
		if(index== arr.length){
			for(String s:out)
				System.out.print(s);
			System.out.println();
		}
		else{
			// for(int i = index; i < arr.length; i++){
				out[index] = "";
				combinations(arr,out,index+1);
				out[index] = arr[index];
				combinations(arr,out,index+1);
			// }
		}
	}

	public static void combinations(String [] arr, StringBuffer out, int index){
			for(int i = index; i < arr.length; i++){
				out.append(arr[i]);
				System.out.println(out.toString());
				combinations(arr,out,i+1);
				out.deleteCharAt(out.length()-1);

			}
	}

	public static void combine(String instr, StringBuffer outstr, int index)
	{
		for (int i = index; i < instr.length(); i++)
		{
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			combine(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}
	} 

	public static void permutations(String [] instr,int l, int h){
		if( l==h){
			for( String s: instr)
				System.out.print(s);
			System.out.println();
		}
		else{
			for( int i=l; i<instr.length; i++){
				instr = swap(instr, l, i);
				permutations(instr,l+1,h);
				instr = swap(instr, l, i); // swap back to original spots
			}
		}

	}

	public static String[] swap(String [] arr,int l, int h){

		String temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;

		return arr;
	}

				// abc
		abc 0				bac
	abc	1   abc 2 		 bac	bca	
abc 2	    acb
	

	
}
