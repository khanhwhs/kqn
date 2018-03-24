package Code_Questions;

public class LongestPreInStrings {
	
	public static void main(String[] args) {
	
		String []str = {"flower", "flow", "flllo","fleet"};
		String pre = str[0];
		int i = 1;
		
		while (i < str.length){
			
			while(str[i].indexOf(pre) != 0){
				pre = pre.substring(0, pre.length() -1);
				System.out.println("pre is: " + pre + "current i :" + i);
			}
			i++;
		}
	
	}

}
