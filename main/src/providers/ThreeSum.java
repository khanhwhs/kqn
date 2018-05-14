// package providers;

public class ThreeSum{
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int i,j,k = 0;
        int n = arr.length;

        int target = 13;
        for(i = 0; i<n-2; i++){  //        0 ... n-2
            for(j = i+1; j<n-1; j++){ //   
                for(k = j+1; k<n; k++){
                    if( arr[i] + arr[j] + arr[k] == target){
                        System.out.println(arr[i] + " + " + arr[j] + " + " + arr[k]);
                    }
                }
            }
        }
            
    }
}
    