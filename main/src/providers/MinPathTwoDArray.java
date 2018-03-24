package Code_Questions;

public class MinPathTwoDArray {
	public static void main(String args[]){
		int array[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int l = array.length;
		int i,j = 0;
		for( i = 0; i < array.length; i++){
			for(j = 0; j < array.length ; j++){
				
				
				if (i==0 && j==0) continue;
				else if ( i == 0) array[i][j] += array[i][j-1];
				else if( j == 0) array[i][j] += array[i-1][j];	
				else array[i][j] = Math.min((array[i][j] + array[i-1][j]), (array[i][j] + array[i][j-1]));
				System.out.println( "i and j :" + i + " " + j + "arrayLength: " + l + "current array[i][j]" + array[i][j]);
				
			}
		}
		
		System.out.println(array[i][j]);
		
	}

}
