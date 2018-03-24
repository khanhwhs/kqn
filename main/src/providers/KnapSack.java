package Code_Questions;

import java.util.HashMap;
import java.util.Map;

//
				//ks(5,0,0)
		//ks(4,1,10)
//ks(2,2,22)



public class KnapSack {
	public static int [] weight = {1,2,3};
	public static int [] value = {6,10,12};
	public static int max = 5;
	public static void main (String [] args){
//		long start = System.nanoTime();
//		System.out.println(knapsack(max,0,0,-1));
//		long end = System.nanoTime();

//	    System.out.println((end - start) + " ns");
	    
	    
	    long start2 = System.nanoTime();
		System.out.println(knapsack2(max,0));
		long end2 = System.nanoTime();

	    System.out.println((end2 - start2) + " ns");
	    
//	    0	1  2  3  4  5
//	    
//	 0	0   0  0  0  0  0
//	    
//	 1  0 	6  6  6  6  6
//	    
//	 2  0	6  10 16 16 16
//		
//	 3  0	6  10 16 18 22
	    
	    int [][] cache = new int[weight.length + 1][max + 1];
	    
	    for(int i = 0; i< cache.length; i++){
	    	for(int j = 0; j < max + 1; j++){
	    		if( i== 0 || j ==0) cache[i][j] = 0;
	    		else if(j - weight[i-1] < 0) cache[i][j] = cache[i-1][j];
	    		else cache[i][j] = Math.max(value[i-1] + cache[i-1][j-weight[i-1]], cache[i-1][j]);
	    	}
	    	
	    }
	    
	    long start3 = System.nanoTime();
		System.out.println(cache[weight.length ][max]);
		long end3 = System.nanoTime();

	    System.out.println((end2 - start2) + " ns");
	    
	    
	    
		return;
	}
	public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer,Integer>>();
	
	public static int knapsack(int currV, int index, int currMax, int max){
		if( index >= weight.length){
			return currMax- value[index-1];
		}
		if(currV < 0){
			currMax = currMax - value[index];
			return currMax;
		}
		if (!map.containsKey(index)) map.put(index, new HashMap<Integer,Integer>());

		if( map.get(index).get(currV) != null) return map.get(index).get(currV);
		
		for (int i = index; i < weight.length; i++){
				int curMax = knapsack(currV - weight[i], index+1, currMax + value[i], max);
//				System.out.println("curMax: " + curMax + " max : " + max);
				if ( curMax > max){
					max = curMax;
				}
		}
		map.get(index).put(currMax, max);
		return max;
	}
	
	
	public static int knapsack2(int maxW , int index){
		if( index == weight.length){
			return 0;
		}
		if(!map.containsKey(index)) map.put(index, new HashMap<Integer,Integer>());
		if(map.get(index).get(maxW) != null) return map.get(index).get(maxW);
		int toReturn;
		if( maxW - weight[index] < 0) toReturn = knapsack2(maxW, index +1);
		else toReturn = Math.max(knapsack2(maxW - weight[index], index +1) + value[index], knapsack2(maxW, index +1 ) );
		map.get(index).put(maxW, toReturn);
		return toReturn;
	}
	
	
//	public static int [] weight = {1,2,3};
//	public static int [] value = {6,10,12};
	
//	                  ks(5,0)
//          ks(4,1) + 6                 ks(5,1)
//     ks(2,2)+10   ks(4,2)      ks(3,2)+10      ks(5,2)
//               ks(1,3)+12      ks(0,3)+12   ks(2,3)+12     ks(5,3)

	

}
