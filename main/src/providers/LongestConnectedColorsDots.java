/**
 * LongestConnectedColorsDots
 */
public class LongestConnectedColorsDots {

    public static int maxLength = Integer.MIN_VALUE;
    public static int [] movRow = {0,0,1,-1};
    public static int [] movCol = {1,-1,0,0};
    public static void main(String[] args) {
        int [][] arr = {{0 , 2 , 2 , 0 , 4 , 4 },
                        {2 , 2 , 0 , 0 , 4 , 4 },
                        {0 , 1 , 1 , 1 , 1 , 4 },
                        {5 , 1 , 7 , 0 , 0 , 0 },
                        {5 , 0 , 2 , 1 , 1 , 0 },
                        {5 , 0 , 0 , 5 , 5 , 0 }};

        boolean [][] visisted = new boolean[arr.length][arr.length];
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for( int j = 0; j<n; j++){
                if(!visisted[i][j]){
                    visisted[i][j] = true;
                    maxLength = Math.max(maxLength, maxCalc(i,j,arr,visisted));
                    System.out.println(maxLength);
                }
            }
        }

        

        
    }

    
    private static int maxCalc(int row, int col, int [][] arr, boolean [][] visisted){
                int max = 0;
                for( int i = 0; i < 4; i++){
                    System.out.println("row : " + row + "  col :" + col  );
                    if(isValid(row + movRow[i], col + movCol[i], arr.length) && 
                        !visisted[row + movRow[i]][col + movCol[i]] && 
                        arr[row][col] == arr[row + movRow[i]][col + movCol[i]]){
                            max++;
                            visisted[row + movRow[i]][col + movCol[i]] = true;
                            max += maxCalc(row + movRow[i],col + movCol[i], arr, visisted);
                        }
                }

                return max;
    }

    private static boolean isValid(int row, int col, int n){
        if( row<0  || row >= n) return false;
        if( col<0  || col >= n) return false;
        return true;
    }
     
}