package Code_Questions;

import java.util.NavigableSet;
import java.util.TreeSet;


public class MaxSubseq {
	
	public static void S(int[] array){
		int max = array[0];
		int sumALL = 0;
		for (int i = 1; i < array.length; i++){
			max = Math.max(max + array[i],array[i]);

			if (max > sumALL)
			{
				
				sumALL = max;
			}
		}
		
		System.out.println(sumALL);
	}
	
	public static void SinRange(int[] array,int x, int y){
		int a = 0;
		int b = 0;
		int n = array.length;
		int j = 0;
		int k = 0;
		for ( int i = 0; i < n; i++){
			while ( (a != n + 1) && ((sum(array,a) - sum(array,i-1)) < x)){		
				a = a + 1;	
			}
			
			while ( (b != n + 1) && ((sum(array,b) - sum(array,i-1)) <= y)){
				
				b = b + 1;
			
			
			j = a;
			
			while ( j < b){
				k = i;
				System.out.print("[ ");
				while (k<=j){
					System.out.print(array[k] + " ");
					k++;
				}
				System.out.print("]");
				System.out.println();
				j++;
			}
			
		}
	}

	
	public static int sum (int[] array, int n){
		int i = 0;
		int sum= 0;
		if ( n == -1){
//			System.out.println("sum = " + sum + " for n = " + n);
			return 0;
		}
		while (i <= n){
			sum = sum + array[i];
			i++;
		}
//		System.out.println("sum = " + sum + " for n = " + n);
		return sum;
	}
	public static int badsum (int[] array, int m, int n){
		int sum= 0;
		while (m<=n){
			sum = sum + array[m];
			m++;
		}
		return sum;
	}
	
	
	
	//find number of sub arrays with A<=sum<=rank 
	public static int subArrayWithSumInRange(int[] A, int a, int b){
		int count = 0;
		TreeSet<Pair> treeSet = new TreeSet<Pair>();
		int cumsum = 0;
		
		for(int i = 0; i< A.length; i++){
			cumsum+=A[i];
			System.out.println("i is at :" + i + " cumsum " + cumsum );
			
			if(A[i] >= a && A[i] <= b){
				System.out.println("A[i] " + A[i]);
				count++;
			}
			else if(cumsum >= a && cumsum <= b){
				System.out.println("cumsum " + cumsum );
				count++;
			}

			NavigableSet<Pair> subSet = treeSet.subSet(new Pair(cumsum-b, i+1), true, new Pair(cumsum-a, i+1), false);
			System.out.println("HAHA subSet: " + subSet );
			if(!subSet.isEmpty()){
				count += Math.abs(subSet.first().second - subSet.last().second)+1;
//				System.out.println("subSet: " + subSet + " where subSet.first().second is: " + subSet.first().second + " subSet.last().second is : " + subSet.last().second + " count is: " + count);

			}
			treeSet.add(new Pair(cumsum, i));
		}
		
		return count;
	}
	
	private static class Pair implements Comparable<Pair>{
		public int first;
		public int second;
		
		public Pair(int first, int second){
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair a) {
			System.out.println("this.first: " + this.first + " and o.first: " + a.first);
//			System.out.println("this.second: " + this.second + " and o.second: " + o.second + " return ( Integer.compare(this.second, o.second)): " + Integer.compare(this.second, o.second));
			if(this.first == a.first)
				
				return Integer.compare(this.second, a.second);
			else
				return Integer.compare(this.first, a.first);
		}

		@Override
		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}
	
	
	public static void main(String[] args){
		int [] array = {2, 5, 1, 1, 2, 2, 3, 4, 8, 2};
//		S(array);
		SinRange(array,3,6);
//		System.out.println(subArrayWithSumInRange(array,4,6));

		
	}
}
