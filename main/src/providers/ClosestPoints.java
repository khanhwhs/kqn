package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//Given an amount of points  (x, y),   find the k points closest to (0, 0).

// dist

// given a list of points, calc k closest points (distance) to origin
public class ClosestPoints {
	
	public static class PtoD implements Comparable<PtoD>{
		private int distance;
		private List<Integer> point = new ArrayList<Integer>();
		
		public PtoD(int distance, List<Integer> point){
			this.distance = distance;
			this.point= point;
		}

		@Override
		public int compareTo(PtoD o) {
			return this.distance - o.distance;
		}
		
	}
	public static void main(String[] args) {
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>(Arrays.asList(1,28)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,23)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,0)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		list.add(new ArrayList<Integer>(Arrays.asList(3,2)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,6)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,7)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,21)));
		list.add(new ArrayList<Integer>(Arrays.asList(1,24)));
	
		System.out.println(list.toString());
		List<ArrayList<Integer>> res = closestP(list,7);
		
		System.out.println(res.toString());
		
		
	}
	
	public static List<ArrayList<Integer>> closestP(List<ArrayList<Integer>> list, int k){
		PriorityQueue<PtoD> pq = new PriorityQueue<PtoD>();
		for(List<Integer> point: list){
			int distance = distance(point);
			pq.add(new PtoD(distance, point));
		}
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int a = 0; a<k;a++){
			res.add((ArrayList<Integer>) pq.poll().point);
		}
		return res;
	}
	
	public static int distance(List<Integer> point){
		if( point.size() > 2 || point.size() <2 ) return -1;
		return (int) Math.sqrt(Math.pow(point.get(0),2) + Math.pow(point.get(1),2));
	}
}
