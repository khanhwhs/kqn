package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//{{1, 2, 3, 4},
//	  {2, 3, 6, 5},
//	  {10,9, 5, 6}};

public class LongestPathIncreasing {
	public static int [][] arr = {{1, 3, 4, 6, 8},
								  {2, 5, 7, 3, 1},
								  {10,8, 9, 2, 1}};
	
	public static List<Integer> finalList = new ArrayList<>();
	
	
	/**
	 * @param args
	 */
	public static void main ( String [] args){
		
		List<Integer> result = new ArrayList<Integer>();
		int i = 0,j = 0;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> maxL = new ArrayList<Integer>();
		ArrayList<Integer> bestL = new ArrayList<Integer>();
		for(i = 0; i<arr.length; i++){
			for(j=0; j< arr[0].length; j++ ){
//				System.out.println("i : " +i +  " j = " + j);
				list.add(arr[i][j]);
				ArrayList<Integer> temp = findMaxList(i,j,list,maxL);
				if( temp.size() > bestL.size()){
					bestL.clear();
					bestL.addAll(temp);
				}
				list.clear();
				maxL.clear();
			}
		}
		
		// BRUCE FORCE : O(n*m*4^(n*m))
		//TOPDOWN MAP: O(n*m)
		
		
		System.out.println(bestL.toString());
		
	}
	static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static ArrayList<Integer> findMaxList(int i, int j,ArrayList<Integer> currL,ArrayList<Integer> maxL){
		int [][] moves = {{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
		int l = arr.length;
		int cl = arr[0].length;
		if( map.containsKey(arr[i][j])){
			if( currL.size() > 0) currL.remove(currL.size() - 1);
			return map.get(arr[i][j]);
		}else{
			for(int []move: moves){
				if (move[0] >= 0 && move[0] < l && move[1] >= 0 && move[1] < cl && arr[i][j] < arr[move[0]][move[1]]){
					currL.add(arr[move[0]][move[1]]);
					ArrayList<Integer> list = findMaxList(move[0],move[1],currL,maxL);
					
				}
			}
		}
		if(maxL.size() < currL.size()){
			maxL.clear();
			maxL.addAll(currL);
			map.put(arr[i][j], maxL);
		}
		if( currL.size() > 0) currL.remove(currL.size() - 1);
		return maxL;
		
	}
	
	public static int findMax(int i, int j,List<Integer> list){
		int l = arr.length;
		int cl = arr[0].length;
		int max = 0;
		int m1 = 0,m2 = 0, m3 = 0, m4 = 0;
		if(i-1>=0 && arr[i][j] < arr[i-1][j]){
			list.add(arr[i-1][j]);
			m1 = findMax(i-1,j,list) +1 ;
		}else m1 = 0;
			
		if(i+1 < l && arr[i][j] < arr[i+1][j]){
			list.add(arr[i+1][j]);
			m2 = findMax(i+1,j,list) + 1;
		}else m2 = 0;
			
		if(j-1>=0 && arr[i][j] < arr[i][j-1]){
			list.add(arr[i][j-1]);
			m3 = findMax(i,j-1,list) + 1;
		}else m3 = 0;
		
		if(j+1 < cl && arr[i][j] < arr[i][j+1]){
			list.add(arr[i][j+1]);
			m4 = findMax(i,j+1,list) + 1;
		}else m4 = 0;
		
		System.out.println(list.toString());
		max = Math.max(m1, max);
		max = Math.max(m2, max);
		max = Math.max(m3, max);
		max = Math.max(m4, max);
		
		return max;
		
	}
	
	public static int findMax2(int i, int j){
		int [][] moves = {{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
		int l = arr.length;
		int cl = arr[0].length;
		int max = 0;
		
		for(int []move: moves){
			if (move[0] >= 0 && move[0] < l && move[1] >= 0 && move[1] < l && arr[i][j] < arr[move[0]][move[1]]){
				max = Math.max(max,findMax2(move[0],move[1]) +1);
			}
		}
		
		return max;
		
	}

}
