package Code_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DiffIJK {
	public static void main(String[] args) {
	ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5,1,2,2,3,4 ));
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	   for( int i : a){
	       if( map.get(i) == null) map.put(i,1);
	       else
	       {
	           int ct =map.get(i) + 1;
	           map.put(i,ct);
	       }
	   }

	int b = 0;
   for(int j:a){
       if (map.containsKey(b+j))
       {
           if (b+j == j){
               if ( map.get(j) > 1)
               {
                   System.out.println("1");
                   break;
               }else System.out.println("0");
           } else System.out.println("1");
       }
    }
	}

}
