package Code_Questions;
//Reverse a linked list 
class Node2{
	int value;
	Node2 next;
}
//cur
// 1->2->3->null   ----- 3->2->1->null

//curr = 3->2->1->null
// prev = 2->1->null
// next = null


public class LLReverse {
	public static void main( String [] args){
		
		Node2 n = new Node2();
		n.value = 1;
		n.next = new Node2();
		n.next.value = 2;
		n.next.next = new Node2();
		n.next.next.value = 3;
		n.next.next.next = new Node2();
		n.next.next.next.value =4;
		n.next.next.next.next =new Node2();
		n.next.next.next.next.value = 5;
		n.next.next.next.next.next = new Node2();
		n.next.next.next.next.next.value = 6;
		n.next.next.next.next.next.next = null;

//		Node2 curr = n;
//		Node2 secondH = secondHalf(curr);
//		reverseLL(secondHalf(curr));
//		secondH.next = reversedNode;
//		print(curr);
		
		
		Node2 head= n;
		Node2 curr= secondHalf(head);
		curr.next = reverseLL(curr.next);
		
		
		
		print(head);
		
		
		
		
	}
	
	public static void print(Node2 n){
		while(n != null){
			System.out.println(n.value);
			n = n.next;
		}
	}
	
	public static Node2 secondHalf(Node2 n){
		
		Node2 curr = n;
		Node2 runner = n;
		
		while(runner != null && runner.next != null ){
			curr = curr.next;
			runner = runner.next.next;
		}
		
		return curr;

	}
	
	public static Node2 reverseLL(Node2 n){
		Node2 curr= n;
		Node2 prev = null;
		Node2 next =null;
		
		while(curr != null){
			next= curr.next;
			curr.next = prev;
			prev = curr;
			curr=next;
		}
		
		return prev;
	}
}
