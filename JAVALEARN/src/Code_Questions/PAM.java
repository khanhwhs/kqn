package Code_Questions;

import java.util.Arrays;
public class PAM {
	
	public static void swap( String array[], int l, int r){
		String temp = array[l];
		array[l] = array[r];
		array[r] = temp;
				
		return;
	}
	
	public static void main( String a[]){
		
		String words = "ABC";
		String[] array = words.split("(?!^)");
		int n = array.length;
		Permu(array,0,n-1);
		return;
	}
	
	public static void Permu(String array[], int l, int r){
		int n = array.length;
		if (l == r){
			String str = "";
			for (String c : array)	
			    str += c.toString();
			System.out.println(str);
		}else{
			for (int i = l; i < n; i++){
				swap(array,l,i);
				Permu(array,l+1, r);
				swap(array,l,i);
			}
		}
	}
	
}
