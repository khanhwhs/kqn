package Code_Questions;


//Given an input amount of change x, write a function to determine the minimum number of coins required to make that amount of change.

//         12 
//       / | \ \
//    neg  2  7 11
//        / |
//       neg n
//        ....


//mc(12)
//3  mc(7)
	
//Bruce Force: x^n
//Dynamic programing -- memorization --- O(x * n)

public class MinChange {
	public static void main(String [] args){
		int [] coins = {25,10,5,1};
		int x = 54;
		int [] cache = new int[x + 1];
		int result = makeChange(x,coins, cache) -1;
		
		System.out.println(result);

	}
	
	public static int makeChange(int x, int [] coins, int [] cache){
		if(x==0) return 1;
		if(cache[x] > 0) return cache[x];
		int min = Integer.MAX_VALUE;
		for(int coin: coins){
			if(x - coin >= 0){
				int currMin = makeChange(x - coin, coins,cache);
				if( currMin < min){
					min = currMin +1;
				}
			}
			
		}
		cache[x] = min;
		return min;
	}
}
