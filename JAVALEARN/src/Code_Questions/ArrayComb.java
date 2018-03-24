package Code_Questions;

import java.util.ArrayList;

//{{1, 2, 3}, {1}, {1, 2}};
//  ^
//  
//  comb(0,[],[[]])
//  comb(1,1,[])
//  comb(2,11,[])


public class ArrayComb {
	
	public static void main(String [] args){
		int [][] arr = {{1, 2, 3}, {1}, {1, 2}};
//		int [][] res = new int[arr.length][arr.length];
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> currL = new ArrayList<Integer>();
		printComb(arr,0,currL,res);
		System.out.println(res.toString());
		
	}
	
	public static void printComb(int [][] arr, int i,ArrayList<Integer> currL,ArrayList<ArrayList<Integer>> res){
		if(i == arr.length){
			
//			System.out.print(currL.toString());
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(currL);
			res.add(temp);
			return;
		}
		
		for(int j = 0; j<arr[i].length; j++){
			currL.add(arr[i][j]);
			printComb(arr,i+1,currL,res);
			currL.remove(currL.size() -1);
		}
	}
}
