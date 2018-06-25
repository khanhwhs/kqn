import java.util.*;

/**
 * StairsSteps
 */
public class StairsSteps {
    public static void main(String[] args) {
        Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
        System.out.println(cntStairs(5,hm));
    }

    public static int cntStairs(int n, Map<Integer,Integer> hm){
        if( hm.containsKey(n)) return hm.get(n);
        else{
            if (n == 1) return 1;
            if(n==2) return 2;
            if( n== 0) return 0;
            hm.put(n, cntStairs(n-1, hm) + cntStairs(n-2, hm) );
        }

        return hm.get(n);

    }
    
}