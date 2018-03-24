package Code_Questions;

import java.util.BitSet;

public class MergeA {
	public static void main(String args[]){
		int [] A = {2,4,6,8,11,23};
		int [] B = {6,8,14,23};
		int [] C = new int[A.length + B.length];
		
		int i = 0,j = 0,k = 0;
		
		while (i<A.length && j<B.length){
			if ( A[i] < B[j])
				C[k++] = A[i++];
			else if( B[j] < A[i])
				C[k++] = B[j++];
			else 
				C[k++] = B[j++];
		}
		
		if(i== A.length)
			while ( j <B.length)
					C[k++] = B[j++];
		if(j== B.length)
			while ( i <A.length)
					C[k++] = A[i++];
//		for ( int x: C)
//			System.out.println(x);
		
//		System.out.println(1&1);
		int [] arr = { 1, 2 ,4, 5,6,1,5,31, 4, 3, 32000 , 31000};
		MergeA checkDup = new MergeA();
		checkDup.checkDup(arr);
		
	}
	
	public void checkDup(int [] arr){
		BitSet bs = new BitSet(32000);
		for(int i = 0; i< arr.length; i++){
			int num = arr[i];
			int num0 = arr[i] - 1;
			if( bs.get(num0)) System.out.println(num);
			else bs.set(num0);
		}
	}
	
	private class BitSet{
		private int [] bitSet;
		public BitSet(int size){
			bitSet = new int[size>>5]; // devide by 32
//			System.out.println("size>>5 : " + bitSet.length);
		}
		
		boolean get(int pos){
			int wordNumber = pos>>5;
			int bitNumber = (pos & 0x1F);
			System.out.println("GET METHOD --- > pos : "+ pos + " and wordNumber : " +wordNumber+ " and bitSet[wordNumber]:" + bitSet[wordNumber]  + " and bitNumber: " + bitNumber + " and 1<<bitNumber: " + (1<<bitNumber) + " and bitSet[wordNumber] & (1<<bitNumber) "+ (bitSet[wordNumber] & (1<<bitNumber)));
			return (bitSet[wordNumber] & (1<<bitNumber)) != 0;
		}
		
		void set(int pos){
			int wordNumber = (pos>>5); // devide by 5
			int bitNumber = (pos & 0x1F); // mod 32
			System.out.println("SET METHOD pos : "+ pos + " and wordNumber : " +wordNumber+ " and bitSet[wordNumber]:" + bitSet[wordNumber]  + " and bitNumber: " + bitNumber + " and 1<<bitNumber: " + (1<<bitNumber) + " and bitSet[wordNumber]| 1<<bitNumber: "+ (bitSet[wordNumber] | (1<<bitNumber)));
			bitSet[wordNumber] |= 1<<bitNumber;
		}
		
	}
}
