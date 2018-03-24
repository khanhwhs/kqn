package Code_Questions;

import java.util.LinkedList;


public class AddOneLL {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static void main( String [] args){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		
		Node reversed = null;
		printReverse(n,reversed);
		System.out.println();
		
		
		Node rN = reverseLL(n);
		Node head = rN;
		while(rN.data + 1 == 10){
			rN.data = 0;
			rN = rN.next;
		}
		rN.data = rN.data + 1;
		
		

		head = reverseLL(head);
		while(head != null){
			System.out.print(head.data);
			head  = head.next;
		}
		
		
		

	}
	public static Node reverseLL(Node n){
		Node curr = n;
		Node prev = null;
		Node next = null;
		while(curr != null){
			next= curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
	
		}
		
		return prev;
	}
	
	public static void printReverse(Node n,Node reversed){
		if(n.next == null){
//			reversed.data = n.data;
			System.out.print(n.data);
			return;
		}
		printReverse(n.next,reversed);
		System.out.print(n.data);
	}
			
}
