package Code_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Node{
	int val;
	Node left;
	Node right;
	 Node(int d) 
	 {
	     val = d;
	     left = right = null;
	 }
}

//			 0
//		    / \
//		   1   2
//		  / \ / \
//		 3  4 5  6
//		   /   \  \
//		  7     8  13

//	//fP(0,4)
//	f(1,4)   2,4
//f(3,4) 1

//r = (0,1->2)
//i = 1
//n =2
//ll =3->4->5->6
		
public class BinaryTreeTargetSum {
	
	public static List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	
	public static void main ( String [] args){
		Node tree = new Node(0);
	     tree.left = new Node(1);
	     tree.right = new Node(2);
	     tree.left.left = new Node(3);
	     tree.left.left.left = null;
	     tree.left.left.right = null;
	     tree.left.right = new Node(4);
	     tree.left.right.right = null;
	     tree.right.right = new Node(13);
	     tree.right.left = new Node(5);
	     tree.right.left.left = null;
	     tree.left.right.left = new Node(7);
	     tree.left.right.left.left = null;
	     tree.left.right.left.right = null;
	     tree.right.left.right = new Node(8);
	     tree.right.left.right.left = null;
	     tree.right.left.right.right = null;
	     ArrayList<Integer> currl = new ArrayList<>();
//	     currl.add(tree.val);
//	     findpath(15,tree,currl);
//	     System.out.println(res.toString());
//	     int ans = findpath(tree,3);
//	     
//	     System.out.println("The path from root to 4 is : " + ans );
	     
	     
//		 	 5
//		    / \
//		   3   7
//		  / \ / \
//		 1  4 6  8
	     
//	     k = 5
//	    		 
//	    n=4
//	    s = 5,4
//	    cur = 1,3,4
	    		 
	    		 
	     
	     Node tree2 = new Node(5);
	     tree2.left = new Node(3);
	     tree2.right = new Node(7);
	     tree2.left.left = new Node(1);
	     tree2.left.right = new Node(4);
	     tree2.right.right = new Node(8);
//	     tree2.right.left = new Node(6);
//	     tree2.left.left.left = null;
//	     tree2.left.left.right = null;
//	     tree2.left.right.left = null;
//	     tree2.left.right.right = null;
//	     tree2.right.left.left = null;
//	     tree2.right.left.right = null;
	     ArrayList<Integer> currl2 = new ArrayList<>();
	     findKsmallest(tree2,currl2,5);
	     System.out.println(currl2.toString());
	     
	     List<LinkedList<Node>>  results = new ArrayList<LinkedList<Node>>();
	     int level =0;
	     LinkedList<Node> list = new LinkedList<Node>();
	     list.add(tree2);
//	     System.out.println(list.get(0).val);
	     results.add(list);
	     
	     while(true){
	    	 LinkedList<Node> ll = new LinkedList<Node>();
	    	 for(int i = 0; i < results.get(level).size(); i++){
	    		 Node left = results.get(level).get(i).left ;
	    		 Node right = results.get(level).get(i).right;
	    		 if(left != null) ll.add(left);
	    		 if(right != null) ll.add(right);
	    	 }
	    	 if( ll.isEmpty()) break;
	    	 else{
	    		 results.add(ll);
	    		 level += 1;
	    	 }
	    	 
	     }
	     
	     System.out.println(results.get(2).size());
	     
	     
	     
	}
	
	public static int findpath(Node n,int x){
		if( n == null) return 0;
		int ans = 0;
		if( n.val == x){
			ans = ans+1;
			return ans;
		}
		ans = findpath(n.left,x);
		if( ans > 0) return ++ans;
		ans = findpath(n.right,x);
		if( ans > 0) return ++ans;
		return 0;
	}
	
	public static void findpath( int target, Node n, ArrayList<Integer> currl){
		if(target == 0){
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(currl);
			res.add(temp);
		}else{
			if(n.left != null){
				currl.add(n.left.val);
				findpath(target - n.left.val, n.left, currl);
	
			}
			
			if(n.right != null){
				currl.add(n.right.val);
				findpath(target - n.right.val, n.right, currl);
			}
		}
		target = target + currl.get(currl.size() -1);
		currl.remove(currl.size() -1);
		
	}
	
	public static void findKsmallest(Node n, ArrayList<Integer> currl,int k){ // kLog
		Stack<Node> s = new Stack<>(); 
		while(true){
			while(n != null){
				s.push(n);
				n = n.left;
			}
			
			if(s.isEmpty()) return;
			
			n = s.pop();
			currl.add(n.val);
			if(currl.size() == k) {
				System.out.println(currl.toString());
				return;
			}
			n = n.right;
		}
		
		
	}
	
//	public static void findKsmallest2(Node n, ArrayList<Integer> currl,int k){ // O(n) if going the normal recursive inorder traversal route;
//		if(n.left == null && n.right == null){
//			if( currl.size() < k){
//				
//			}
//			currl.add(n.val);
//			
//		}
//		
//		
//		
//	}
	
	
//	    5
//    /   \
//   3     7
//  / \   / \
// 1   4 6   8
// 

}
