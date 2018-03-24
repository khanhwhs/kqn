package Code_Questions;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.

//push(1)
//
//(x,currMin)
//
//(1,1)
//
//push(7)
//
// top
//(7,1)-->(1,1)
//
//push(3)
//top
//(3,1)-->(7,1)-->(1,1)
//
//
//getMin()
//return top.currMin
//		
//pop()
//temp = top.next;
//top.next = null;
//top = temp;
//top
//(7,1)-->(1,1)

class Node{
	int value;
	int currMin;
	Node next;
	
	public Node ( int value, int currMin){
		this.value = value;
		this.currMin = currMin;
	}
}

public class MinStack {
	Node top;
	
	public void push(int value){
		if(top ==null){
			top = new Node(value,value);
		}else{
			Node temp = new Node(value, Math.min(value, top.currMin));
			temp.next = top;
			top = temp;
		}
	}
	public int getMin(){
		if( top== null){
			return 0;
		}else{
			return top.currMin;
		}
	}
	
	public void pop(){
		if( top== null){
			return;
		}else{
			Node temp = top;
			top.next = null;
			top = temp;
		}
	}

}
