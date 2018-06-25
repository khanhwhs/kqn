import java.util.*;


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
		int [] coins = {25,5,10,1};
		int x = 3;
		int [] cache = new int[x + 1];
		Map<Integer,List<Integer>> hm = new HashMap<>();
		
		int result = makeChange(x,coins, cache) -1;
		List<Integer> res = makeChange(x,coins, hm);
		System.out.println(result);

		for(int i: res) System.out.print( i + " ");
		System.out.println();

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

	public static List<Integer> makeChange(int x, int [] coins, Map<Integer,List<Integer>> hm){
		hm.put(0, new ArrayList<Integer>());
		for( int i = 1; i<=x; i++){
			for(int j = 0; j<coins.length; j++){
				if(i-coins[j] >= 0){
					List<Integer> temp = new ArrayList<>();
					temp.addAll(hm.get(i-coins[j]));
					temp.add(coins[j]);

					if(hm.containsKey(i)){
						if(temp.size()< hm.get(i).size()) hm.put(i,temp);
					}else{
						hm.put(i,temp);
					}
				}
			}
		}

		return hm.get(x);
	}
}
