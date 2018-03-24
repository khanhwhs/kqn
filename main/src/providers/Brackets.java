package Code_Questions;

import java.util.Stack;


public class Brackets {
public static boolean isBalanced(String input){
	Stack<Character> stack = new Stack<>();
	for(int i = 0;i < input.length(); i++){
		System.out.println(stack);
		if(input.charAt(i)=='(' || input.charAt(i) == '{' || input.charAt(i) == '['){
			stack.push(input.charAt(i));
		}		
		else if(input.charAt(i)==')'){
			if(!stack.isEmpty() && stack.pop()!='(')
				return false;
		}else if(input.charAt(i)=='}'){
			if(!stack.isEmpty() && stack.pop()!='{')
				return false;
		}else if(input.charAt(i)==']'){
			if(!stack.isEmpty() && stack.pop()!='[')
				return false;
		}
		
		
	}
	return stack.isEmpty();
	}

//Check to see if these are balanced
public static void main(String[] args) {
	String input = "[()]{}{[()()]()}";
	System.out.println(isBalanced(input));
	}

}
