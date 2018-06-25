/**
 * FindCycleInArray
 */
public class FindCycleInArray {
    public static void main(String[] args) {
                               
        int [] arr = {5,4,3,1,2,3};

       
                    //    l     m   h            
        int [] arr2 = {3,4,5,1,2,3};
                    //    l   h

        // total = 1 + ( arr, 0, 2)


        int [] arr3= {1,2,3,4,5};
        int [] arr4 = {1,2,3,4,2,1};

        System.out.println(findIfCycleExist(arr));
        System.out.println(findIfCycleExist(arr2));
        System.out.println(findIfCycleExist(arr3));
        System.out.println(findIfCycleExist(arr4));
    }



    public static boolean findIfCycleExist(int [] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if( arr[i] >arr[(i+1) % arr.length]){
                max++;
            }
        }

        return max <= 1;
    }

    public static boolean findIfCycleExist2(int [] arr){
        // System.out.println("TOTAL IS : " + count(arr, 0, arr.length-1));
        return count(arr, 0, arr.length-1) <= 1? true: false;
    }

    public static int count(int [] arr, int low, int high){
        int total = 0;

        // System.out.println("l: " + low + "h: " + high);
        // when array is not rotated at all
        if (high < low |  high == low) return 0;
        int mid = low + (high - low)/2;
        if( arr[mid] > arr[high] && mid +1 < arr.length){
            total = 1 + count(arr, mid+1, high);

        }

        if((mid-1 > 0) && arr[mid-1] > arr[mid]){
            total = 1 + count(arr, low, mid -1);
        }

        return total;
    }







    //Find the Rotation Count in Rotated Sorted array
    public static int countRot(int [] arr, int low, int high ){
           // This condition is needed to handle the case
    // when array is not rotated at all
    if (high < low)
    return 0;

    // If there is only one element left
    if (high == low)
        return low;

    // Find mid
    int mid = low + (high - low)/2; /*(low + high)/2;*/

    // Check if element (mid+1) is minimum element.
    // Consider the cases like {3, 4, 5, 1, 2}
    if (mid < high && arr[mid+1] < arr[mid])
    return (mid+1);

    // Check if mid itself is minimum element
    if (mid > low && arr[mid] < arr[mid - 1])
    return mid;

    // Decide whether we need to go to left half or
    // right half
    if (arr[high] > arr[mid])
    return countRot(arr, low, mid-1);

    return countRot(arr, mid+1, high);
    }

                    // m
    // int [] arr = {5,4,3,1,2,3};

    // ct(arr,0,5)
    //     mid = 3;
    //     count = 1;
    //     ct(arr,0,3);
    //         mid = 1;
    //         count = 1
    //             ct (arr, 1,3)
    //                 mid = 2

        
    
}