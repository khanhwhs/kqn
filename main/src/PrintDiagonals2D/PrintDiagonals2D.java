package PrintDiagonals2D;

import java.util.ArrayList;

public class PrintDiagonals2D {
	public static void main(String[] args) {
		int [][] array = {{1,2,3,4},{5,6,7,8},{1,2,3,4},{5,6,7,8}};
		int i = 0;
		int l = array.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int offset = 0;
		while (i< (2*l-1)){
			offset = i<l ? 0:i-l+1;
			ArrayList<Integer> row = new ArrayList<Integer>();
			for ( int j = offset; j<i - offset; j++){
				row.add(array[j][i-j]);
			}
			res.add(row);
			
		}
		
	}

}
