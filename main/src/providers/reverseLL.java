package Code_Questions;

import javax.print.event.PrintEvent;

public class reverseLL {
	
	private static class Node{
		int val;
		Node next;
		Node(int d) {
            val = d;
            next = null;
        }
	}
	
	public static void main(String args[]){
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = null;
		Node result = null;
		reverse(node,result);
		printList(result);
		
		

	}
	
	public static void reverse(Node n, Node result){
		if ( n == null){
			result = n;
			return;
		}
		reverse(n.next, result);
		result.next = n;
		return;
	}
	
	
	
	// prints content of double linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
	}
	
	// curr = 1->null

	// prev = 1->null
	// next = 2->3->4->null
	
	
	static /* Function to reverse the linked list */
    Node reverse2(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
	
}


