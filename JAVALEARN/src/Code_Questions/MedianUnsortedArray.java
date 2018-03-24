package Code_Questions;

import java.util.Collections;
import java.util.PriorityQueue;

//p = 6
//maxH = 1 2 3 4 5 
//minH = 5 5 6 57 8


public class MedianUnsortedArray {
	public static void main( String [] args){
		int [] arr = {1,5,5,2,6,4,3,5,57,8};
		PriorityQueue<Integer> maxH = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		PriorityQueue<Integer> minH = new PriorityQueue<Integer>();
		int p = arr[(arr.length/2)];
		for (int i: arr){
			if(i<=p) maxH.add(i);
			else minH.add(i);
		}
		while (maxH.size() > maxH.size()) maxH.add(minH.poll());
		while (maxH.size() < maxH.size()) minH.add(maxH.poll());
		
		if( (maxH.size() - minH.size()) == 0) System.out.println((maxH.poll() + minH.poll())/2);
		if( (maxH.size() > minH.size())) System.out.println(maxH.poll());
		if( (maxH.size() < minH.size())) System.out.println(minH.poll());
		
		
	}
	
	

}
