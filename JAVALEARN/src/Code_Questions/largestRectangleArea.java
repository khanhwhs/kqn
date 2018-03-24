package Code_Questions;

import java.util.Stack;

public class largestRectangleArea {
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
				System.out.println("p is:" + p + "and h is:" + h + " and w is:" + w);
			}
			System.out.println(stack);
	 
		}
		System.out.println("CURRENT STACK" + stack + "and i is:" + i);
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			System.out.println("p is:" + p + "and h is:" + h + " and w is:" + w);
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
	
	public static void main(String[] args){
		int [] height = {1,3,1,1,2};
		System.out.println(largestRectangleArea(height));
	}

}
