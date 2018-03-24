package Code_Questions;

public class AllPem {
	public int totalPerms;
	private void solving(String str){
		int length = str.length();
		boolean[] used = new boolean[length];
		StringBuffer output = new StringBuffer(length);
		Perm(str,output,used,length,0);
	}
	private void Perm(String str, StringBuffer output, boolean[] used, int length, int pos){
		
		if ( pos == length){
			System.out.println(output);
			totalPerms++;
		}else
		{
			for( int i = 0; i < length; i++){
					if (used[i]) continue;	
					output.append(str.charAt(i));
					used[i]=true;
					Perm(str,output,used,length,pos+1);
					output.deleteCharAt(output.length() - 1);
					used[i] = false;
			}
		
			
			
		}
		
		
	}
	 public static void main(String args[]) {
		 AllPem problem = new AllPem();
		 problem.solving("ABC");
		 
		 System.out.println("TOTAL PERMS is " + problem.totalPerms);
		 
	 }
}
