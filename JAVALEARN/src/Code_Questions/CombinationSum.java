package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {
	
	public static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
	  void CombinationToSum( int [] arr, int sum, ArrayList<Integer> list, int start){
	      if(sum == 0){
	        map.put(sum,list);
	        for( int i: list){
	              System.out.print( i + " ");
	        }
	        System.out.println();
	      }
	      if( sum < 0) return;
	      if(map.containsKey(sum)){
	        list = new ArrayList<Integer>(map.get(sum));
	        return;
	      }
	      for ( int i = start; i< arr.length; i++){
	          list.add(arr[i]);
	          CombinationToSum(arr, sum - arr[i], list, i);
	          
	          list.remove(list.size() - 1);

	      }
	      
	  }
	  
	  
	  public static void main(String[] args) {

	    int [] arr = {1,2,3};
	    int money = 3;
	    CombinationSum sol = new CombinationSum();
	    ArrayList<Integer> pq = new ArrayList<>();
	    sol.CombinationToSum(arr,3,pq,0);
//	    System.out.println(map.toString());

	  }

}
