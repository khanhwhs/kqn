/**
 * SmallestMissing
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class SmallestMissing {
    public static void main(String[] args) {
        int [] arr = {1};
        // int [] arr = {1,2,0};
        // int [] arr = {3,4,-1,1};

        if(arr.length == 0) return;
        int res = 0;
        for(int i = 0; i < arr.length; i++){

            if(arr[i] <=0) arr[i] = arr.length +1;
        }
        for(int i = 0; i < arr.length; i++){
            
            if(Math.abs(arr[i]) > arr.length || arr[i]==0) continue;
            //             System.out.println(i);
            //      System.out.println(arr[i]);
            // System.out.println("arr[Math.abs(arr[i]) - 1] :   " + arr[Math.abs(arr[i]) - 1]);
            if( arr[Math.abs(arr[i]) - 1] > 0){
      
                arr[Math.abs(arr[i]) - 1] = arr[Math.abs(arr[i]) - 1]*-1;
            }
        }
        // for(int i = 0; i < arr.length; i++){
        //      System.out.println(arr[i]);
        // }
        int k = 0;
        for(; k < arr.length; k++){
            if(arr[k] >= 0){
                res = k+1;
                break;
            }
        
        }

        if(res == 0) res = k+1;

        System.out.println(res);

    
    }
    
}


//{-3,4,-1,-1};