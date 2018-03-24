package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestFlight {
	
	public static final int Max = Integer.MAX_VALUE;
	public int currMin = Integer.MAX_VALUE;
	public static void main(String [] args){
		BestFlight best = new BestFlight();
		int [][] routes = {{0, 1, 3, 7},
						   {Max, 0, 1, 1},
						   {Max, Max, 0, 1},
						   {Max, Max, Max, 0}};
		List<Integer> route = new ArrayList<Integer>();
		List<Integer> bestRoute = new ArrayList<Integer>();
		long startTime = System.nanoTime();

//		bestRoute = best.findBest( routes, 0, 0, 3, route,bestRoute);
		bestRoute = best.findBest( routes, 0, 0, 3, route);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("TOTAL TIME IS : " + totalTime);
		
		
//		System.out.println("resultF: " + result);
		System.out.println("bestRoute: " + bestRoute.toString());
	
		
		
	}
	public Map<Integer, Integer> map = new HashMap<>();
	int  findBest2(int [][] routes, int currSum, int s, int e, List<Integer> route, List<Integer> bestRoute ){
		if (s == e	) {
			if( currSum < currMin){
				currMin = currSum;
				bestRoute.clear();
				bestRoute.add(0);
				bestRoute.addAll(route);
				
			}
			return currMin;
		}
		if( map.containsKey(s)) {
			return map.get(s);
		}
		for( int i = 0; i<routes.length; i++){
			if(routes[s][i] != Max && s != i ){	

				route.add(i);
				int result = findBest2(routes, currSum + routes[s][i], i, e,route,bestRoute);
				
				map.put(i, currSum + routes[s][i]);
//				System.out.println("map: " + map.toString());
				route.remove(route.size() -1);
			}
			
		}
		
		return currMin;
		
	}
	
	
	public List<Integer> findBest(int [][] routes, int currSum, int s, int e, List<Integer> route ){
		if (s == e	) {
			if( currSum < currMin){
				return route;
				
			}
		}

		List<Integer> bestRoute = new ArrayList<Integer>();
		for( int i = 0; i<routes.length; i++){
			if(routes[s][i] != Max && s != i ){	

				route.add(i);
				List<Integer> best = findBest(routes, currSum + routes[s][i], i, e,route);
				if(bestRoute!= null) bestRoute.clear();
				bestRoute.addAll(best);
				route.remove(route.size() -1);
			}
			
		}
		
		return bestRoute;
		
	}

}
