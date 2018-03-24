package Code_Questions;

import java.util.Stack;

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
		
		
		
	}
	
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty())  return;
		int temp = stack.pop();
		reverse(stack);
		iB(stack,temp);
	}
	
	public static void iB(Stack<Integer> s , int x){
		if(s.isEmpty()) {
			s.push(x);
			return;
		}
		int temp = s.pop();
		iB(s,x);
		s.push(temp);
	}
}
