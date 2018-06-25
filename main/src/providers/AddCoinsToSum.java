//stamps with 1, 3, 7 cents, how many ways to have a total 100 cents
import java.util.*;
/**
 * AddCoinsToSum
 */
public class AddCoinsToSum {
    public static void main(String[] args) {
        int [] cents = {1,3,7};
        int target = 17;
        Map<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,0);
        int result = countWays(target,cents, hm);
        int result2 = countWays(target, cents);
        System.out.println(hm.toString());
        System.out.println(result2);


        int [] cache = new int [target+1];
        for (int i = 1; i <= target; i++)
            cache[i] = -1;

        int minChange = makeChange(target, cents, cache);

        System.out.println("minChange is : " + minChange);

    }
    public static int totalWays = 0;
    private static int countWays(int target, int [] cents,  Map<Integer,Integer> hm ){
        if(hm.containsKey(target)) return hm.get(target);
        int ways = 0;
        if(target == 0){
            return 1;
        }else{
            for(int cent : cents){
                if((target-cent) >= 0){
                    ways += countWays(target-cent, cents,hm);
                    
                    // System.out.println("target is : " + target + "---- current cent is: " + cent + " total is: " +   totalWays);
                }
            }
            hm.put(target,ways);
        }
        return hm.get(target);
    }

    private static int countWays(int target, int [] cents){
        int l = cents.length;
        int [] total = new int[target + 1];
        total [0] = 1;
        for ( int i = 1; i <= target; i++){
            for( int j = 0; j < l; j++){
                if((i - cents[j]) >= 0)
                    total[i] += total[i - cents[j]];
            }
        }

        return total[target];


    }

    public static int makeChange(int x, int [] coins, int [] cache){
		if(cache[x] >= 0) return cache[x];
		int min = Integer.MAX_VALUE;
		for(int coin: coins){
			if(x - coin >= 0){
				int currMin = makeChange(x - coin, coins,cache);
				if( currMin < min){
					min = currMin;
				}
			}
			
		}
		cache[x] = min + 1;
		return cache[x];
	}


    
}    

//           1  1  1 2   
                    //         7
                    //     6   4
                    // 5   3
            //     4    2   
            //  3   1
        //     2
        //   1
        // 0    