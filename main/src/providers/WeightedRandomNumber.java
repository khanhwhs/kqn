package Code_Questions;

import java.util.Random;

public class WeightedRandomNumber {
	public static void main( String [] args){
		String [] arr = {"A","B","C"};
		int [] w = {1,1,12};
		int sum = 0;
		for(int i: w){
			sum += i;
		}
		
		Random rand = new Random();
		 
		int random = rand.nextInt(sum);
		int currS = 0;
		for(int i = 0; i < arr.length; i++){
			currS += w[i];
			if(currS>random){
				System.out.println("random is: " + random+ " -----> " +arr[i]); break;
			}
		} // O(n) and 0(1)
		
		// TRADE OFF with O(1) and O(n) by preprocessing, building String cache.
	}

}
