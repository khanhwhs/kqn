
import java.util.ArrayList;
/**
 * Print2DArrayDia
 */
public class Print2DArrayDia {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int offset;

        for(int i = 0; i < arr.length*2 -1; i++){
            offset = i > arr.length -1? i-arr.length+1: 0;
            ArrayList<Integer> row = new ArrayList<Integer>();
            for( int j = offset; j <= i-offset; j++){
                row.add(arr[j][i-j]);
            }
            res.add(row);
        }

        for(ArrayList<Integer> list : res){
            for(int i: list){
                System.out.print( i + " ");
            }
            System.out.println(" ");
        }
    }
    
}




// 1  2  3  4
// 5  6  7  8
// 9 10 11 12
// 13 14 15 16

// i = 0    00
// i = 1    01,10
// i = 2    02,11,20
// i = 3    03,12,21,30    offset = 0  j
// i = 4    13, 22, 13      
// i = 5    23, 32
// i = 6    33