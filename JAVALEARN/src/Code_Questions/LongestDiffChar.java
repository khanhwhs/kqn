package Code_Questions;

public class LongestDiffChar {
	
	public static void main(String[] args) {
		String input = "khanhnguyen";
		int l = input.length();
		int current  = 0;
		int slow = 0;
		int ans = 0;
		boolean []temp = new boolean[128];
//		System.out.println("l: " + l);
		while ( current < l){
			if (!(temp[input.charAt(current)])){
				
				temp[input.charAt(current)] = true;
				current++;
				ans = Math.max(ans, current - slow);
			}else
			{
				temp[input.charAt(slow)] = false;
				slow++;
			}
		}
		
		System.out.println("ans: " + ans);
		
		
		// remove cha already see
		
		boolean[] seen = new boolean[256];
		char[] chars = {'b', 'l', 'a', 'h', 'h', ' '};
		int size = 0;
		for (int j = 0; j < chars.length; j++) {
		    char c = chars[j];
		    if (!seen[c]) {
		    	chars[size++] = chars[j];
		        seen[c] = true;
		    }
		}
		System.out.println("new char size: " + size);
		
	}
}
