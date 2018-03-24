

// package Code_Questions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.Map.Entry;

public class TreeColumnPrint {
	// A binay tree node
	static class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        right = left = null;
	    }
	}
	public static void main(String args[]) 
	{

		
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.right.right = new Node(6);
		tree.left.left.left = new Node(7);
		tree.left.left.right = new Node(8);
		tree.right.right.left = new Node(9);
		tree.right.right.right = new Node(10);

				// 			1
				// 	2          		3
				//   4   5      			6
		Queue<Node> q = new LinkedList<>();
		Map<Integer, ArrayList<Node>> map = new TreeMap<>();
		
		printV(map,0,tree);

		// System.out.println(map.toString());
		// System.out.println(tree.left.data);

		for (Entry<Integer, ArrayList<Node>> entry : map.entrySet())
			{
				for(Node i: entry.getValue()){
					System.out.print(i.data + " ");
				}
				System.out.println();
				
			}


		// q.add(tree);
		// ArrayList<Node> list = new ArrayList<>();
		// list.add(tree);
		// map.put(0,list);
		// while(!q.isEmpty()){
		// 	Node currNode = q.remove();
			

		// }
		


		
	}

	// 			1
	// 		2		3	
	// 	4	  5   6   7
	// 8     9  			10

	// map = 

	// pv([0:1, ],0,1)
	// pv([0:1, ],-1,1)

	public static void printV(Map<Integer, ArrayList<Node>> map, int hd, Node n){
		if (n == null)
			return;
		if(map.containsKey(hd)){
			map.get(hd).add(n);
			return;
		}else{
			ArrayList<Node> list= new ArrayList<>();
			list.add(n);
			map.put(hd,list);

			printV(map,hd-1,n.left);
			printV(map,hd+1,n.right);
			return;
		}
	}

}
