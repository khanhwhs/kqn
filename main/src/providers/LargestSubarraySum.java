/**
 * LargestSubarraySum
 */
public class LargestSubarraySum {
    public static void main(String[] args) {
        int [] arr = { -1,2,-2,5,4,-3,2,3};
                        // ^        ^
        // int [] res= new int[2];
        // int l = 0;
        // int h = 1;
        int max = 0;
        int curr = 0;
        for( int i = 0; i < arr.length; i++){
            curr = curr +arr[i];
            max = max < curr ? curr : max;
            curr = curr < 0 ? 0 : curr;
        }

        System.out.println(max);

    }
    
}