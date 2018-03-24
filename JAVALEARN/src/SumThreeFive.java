

//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//
// 
//
//Find the sum of all the multiples of 3 or 5 below 1000.


	import java.util.Arrays;
	
	
public class SumThreeFive {
	public static void main( String [] args){
		int sum = 0;
		int i = 0;
		
		while( i< 1000){
			if( i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
			i++;
		}
		
		System.out.println( "sum of all the multiples of 3 or 5 below 1000 is: " + sum);
		
		
		
		int [][] twod = genSpiral(4);
//		System.out.println( "test " + twod[1][0]);
		
	}

	  public static int[][] genSpiral(int n) {
	   if (n<=0) {
	    throw new IllegalArgumentException("N must be >0");
	   }
	   int[] dc = new int[]{1,0,-1,0};
	   int[] dr = new int[]{0,1,0,-1};
	   int dir = 0, val=0, r=0, c=0,limit=n*n;
	   int[][] matrix = new int[n][n];
	   while (val++ < limit) {
		   
			 System.out.println( "0    r and c are  " + r + "   " + c);
		    matrix[r][c] = val;
		    r += dr[dir];
		    c += dc[dir];
		    System.out.println( "1    r and c are  " + r + "   " + c);
		    if (isInvalid(matrix,r, c)) {
			     r-= dr[dir];
			     c-=dc[dir];
			     System.out.println( " 2    r and c are  " + r + "   " + c);
			     dir = (dir+1)%4;
			     r+= dr[dir];
			     c+= dc[dir];
			     System.out.println( "3    r and c are  " + r + "   " + c);
		    }
	   }
	   return matrix;
	  }
	  private static boolean isInvalid(int[][] m, int r, int c) {
	   return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
	  } 

}
