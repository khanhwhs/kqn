package Code_Questions;

public class FindIslands {
	public static int mat[][] = {{1, 1, 0, 0, 0},
								 {0, 1, 0, 0, 1},
								 {1, 0, 0, 1, 1},
								 {0, 0, 0, 0, 0},
								 {1, 0, 1, 0, 1}};
	
	// look at all direction, appending allowable move that to a list until you can find any thing
	public static int [] mR = {1,-1, 0, 0,-1,1, 1, -1};
	public static int [] mC = {0, 0,-1, 1, 1,1,-1, -1};
		
	public static void main ( String [] args){
		boolean [][] visited = new boolean[mat.length][mat[0].length];
		int ct = 0;
		for( int i = 0; i < mat.length; i++){
			for(int j = 0; j< mat[0].length; j++){
				if(!visited[i][j] && mat[i][j]== 1){
					going(i,j,visited);
					ct++;
				}
			}
		}
		
		System.out.println(ct);
	}
	// COMPLEXITY: O(ROW x COL)
	
	
	public static void going(int i, int j, boolean [][] visited){
		visited[i][j] = true;
		for( int k = 0; k<8; k++){
			if((i + mR[k] >=0 && i + mR[k] < mat.length) && (j + mC[k] >=0 && j + mC[k] < mat[0].length) && 
					(mat[i+mR[k]][j+mC[k]] ==1 && !visited[i+mR[k]][j+mC[k]])){
				going(i + mR[k], j + mC[k], visited);
			}
		}
	}

}
