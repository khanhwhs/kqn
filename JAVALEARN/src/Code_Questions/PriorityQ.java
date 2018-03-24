package Code_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.PriorityQueue;

public class PriorityQ {
	
	private static class PQ implements Comparable<PQ>{
		private int str;
		private String string;
		public PQ(int str, String string){
			this.str = str;
			this.string = string;
		}
		
		@Override 
		public int compareTo(PQ n){
			return this.str - n.str;
		}
		
//		NavigableMap map = new NavigableMap();
		
	}
	
	
	private static class NodeI{
		private int start;
		private int end;
		public NodeI(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	
	public static void main( String args[]){
		System.out.println("aaa".compareTo("bbb"));

		
		
		ArrayList<PQ> list = new ArrayList<>();
		list.add(new PQ(1, "khanh"));
		list.add(new PQ(2, "hi"));
		list.add(new PQ(3, "hello"));
		list.add(new PQ(2, "leggo"));
		
		ArrayList<NodeI> list2 = new ArrayList<>();
		list2.add(new NodeI(1,3));
		list2.add(new NodeI(2,6));
		list2.add(new NodeI(8,10));
		list2.add(new NodeI(15,20));
		
		Collections.sort(list2, new Comparator<NodeI>() {
			public int compare(NodeI a, NodeI b){
				return a.start - b.start;
			}
			
		});
		for ( PQ i : list){
			System.out.println("num is "+ i.str +  " str is: " + i.string);
		}
		
		
		NodeI prev = list2.get(0);
		ArrayList<NodeI> res = new ArrayList<>();
		for( int i = 1; i< list2.size(); i++){
			NodeI curr = list2.get(i);
			
			if(curr.start > prev.end){
				res.add(prev);
				prev = curr;
			}else{
				NodeI merged = new NodeI(prev.start, curr.end);
				prev = merged;
			}
		}
		
		res.add(prev);
		for( int i = 0; i < res.size(); i++){
			System.out.println( res.get(i).start + " and  " + res.get(i).end);
		}
		
		
		
		
		
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		
//		pq.add(4);
//		pq.add(7);
//		pq.add(1);
//		pq.add(8);
//		
//		int n = pq.poll();
//		System.out.println(n);
//		n = pq.poll();
//		System.out.println(n);
//		n = pq.poll();
//		System.out.println(n);
//		n = pq.poll();
//		System.out.println(n);
		
		
		
	}
	
	private class Node{
		String val;
		Node next;
		public Node(String val) { 

		       this.val = val;

		    }
	}
	

}
