package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//cL = 1 2 10 8 5 3 

public class ShortestPath2DMatrix {
	
	public static int [][] arr = {{1, 3, 4, 6, 8},
		  						  {2, 5, 7, 3, 1},
		  						  {10,8, 9, 2, 1}};
	
	public static int[] mR = {1,-1,0,0};
	public static int[] mC = {0,0,1,-1};
	

public static List<Integer> finalList = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,11,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1));


/**
* @param args
*/
public static void main ( String [] args){
	List<Integer> currL = new ArrayList<>();
	shortestPath(0,0,2,2,currL);
	System.out.println(finalList.toString());
	
}

public static void shortestPath(int i, int j, int x, int y, List<Integer> currL){
	if(i==x && j ==y && (finalList.size() > currL.size() || finalList.size() == 0)){
		finalList.clear();
		List<Integer> temp = new ArrayList<>();
		temp.addAll(currL);
		finalList.addAll(temp);
		return;
	}
	for( int k = 0; k<4; k++){
		if(i+mR[k] < arr.length && i+mR[k] >= 0 && j+mC[k] < arr.length && j+mC[k] >= 0 && !currL.contains(arr[i+mR[k]][j+mC[k]])){
			currL.add(arr[i+mR[k]][j+mC[k]]);
			shortestPath(i+mR[k], j+mC[k], x, y, currL);
		}
	}
	if( currL.size() > 0) currL.remove(currL.size() - 1);
	return;
	
	
}

}
