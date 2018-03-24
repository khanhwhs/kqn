package Code_Questions;

public class ChoppingCorrectly {
	public static void main(String [] args){
		String s = "one two three four five six seven eight nine";
		int l = 15;
		
		int lastindex = 0;
		
		while(lastindex < s.length()){
			int currEnd = lastindex + l;
			if( currEnd < s.length()){
				String tempS = s.substring(0, currEnd);
				int actualE = Math.min(tempS.length(), tempS.lastIndexOf(" "));
				System.out.println(s.substring(lastindex,actualE));
				lastindex = actualE + 1;
			}else{
				System.out.println(s.substring(lastindex,s.length()));
				lastindex = s.length();
			}
		}
	}
}
