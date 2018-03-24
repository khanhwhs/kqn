package Code_Questions;

public class UniquePathTwo {
	
	

public static void main( String args[]){
	
	int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
	int m = obstacleGrid.length; 
	int n = obstacleGrid[0].length;
    int [][] uniquePaths = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,0,0}};
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            uniquePaths[i][j] = 0;
            if (obstacleGrid[i][j] == 1) continue;
            if (i == 0 && j == 0) uniquePaths[i][j] = 1;
            if (i > 0) uniquePaths[i][j] += uniquePaths[i-1][j];
            if (j > 0) uniquePaths[i][j] += uniquePaths[i][j-1];
        }
    }
    System.out.println(uniquePaths[m-1][n-1]);
}

}
