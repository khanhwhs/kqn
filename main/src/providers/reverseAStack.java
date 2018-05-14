// package Code_Questions;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class reverseAStack {
	public static void main(String [] args){
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.toString());
		reverse(s);
		System.out.println(s.toString());


		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		reverseQueue(queue);
		queue.remove();
		System.out.println(queue.toString());
		
		
		
	}

	// s = 1 2 3 4

	// reverse( 1 2 3 4)
	// temp = 4;
	// reverse(1 2 3)
	// temp = 3;
	// reverse(1 2)
	// temp = 2;
	
	// s = [2,1]


	// s = 4
	// temp = 4

	
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		int temp = stack.pop();
		reverse(stack);
		// stack.push(temp);
		iB(stack,temp);

	}
	
	public static void iB(Stack<Integer> s , int x){
		if(s.isEmpty()){
			s.push(x);return;
		}
		int temp = s.pop();
		iB(s,x);
		s.push(temp);
	}


	// Q = 1 2 3 4

	// 1 

	// 2

	// 3

	// 4

	public static void reverseQueue(LinkedList<Integer> queue){
		if(queue.isEmpty()) return;
		int temp = queue.remove();
		reverseQueue(queue);
		queue.add(temp);

	}
}
