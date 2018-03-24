package Code_Questions;

import java.util.Arrays;

public class SmallestNumCoins {
	
	public static void main(String[] args){
		int [] coins = {25,10,5,1};
		
		System.out.println(change(32,coins));
//		System.out.println(change2(32,coins));
		
	}
	
	public static int change( int x, int[] coins){
		int[] cache = new int[x];
		for ( int i = 1; i < x; i++ ) cache[i] = -1;
		return change(x,coins,cache);
	}

	private static int change(int x, int[] coins, int[] cache) {
		if (x==0) return 0;
		int min = x;
		System.out.println("x is: " + x);
		for ( int coin: coins){
			
			System.out.println(Arrays.toString(cache));
			if ( x-coin >= 0){
				int c;
				if ( cache[x-coin] >= 0) c = cache[x- coin];
				else{
					c = change(x-coin, coins, cache);
					cache[x-coin] = c;
				}
				if(min > c+1) min = c+1;
			}
		}
		return min;
	}
	
	public static int change2( int x, int[] coins){

		
		if (x==0) return 0;
		int min = x;
		System.out.println("x is: " + x);
		for ( int coin: coins){
			
			if ( x-coin >= 0){
				int c = change2(x-coin, coins);
				if ( min > c+1) min = c+1;
			}
		}
		return min;
	}

}
