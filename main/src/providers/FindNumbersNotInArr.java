import java.util.*;

/**
 * FindNumbersNotInArr
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * O(n) O(1)
 */
public class FindNumbersNotInArr {

    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        int max = Integer.MIN_VALUE;
        // {-4,-3,-2,-7,8,2,-3,-1};
        List<Integer> res= new ArrayList<>();
        for(int i = 0; i< arr.length; i++){
            
            if(arr[Math.abs(arr[i]) - 1] > 0){
                // System.out.println(Math.abs(arr[i])-1);
                arr[Math.abs(arr[i]) - 1] = arr[Math.abs(arr[i]) - 1] * (-1);
            }
        }
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] > 0) res.add(i+1);
        }

        System.out.println(res.toString());
    }
    
}