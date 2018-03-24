package Code_Questions;

public class BitDevide {
	public static void main ( String [] args){
		int x = 23; //00010111
		int y = 4; // 00000100 --> 100000  shift 3      0001000
		
		int temp =1;
		while (y<x){
			y <<= 1;
			temp <<=1;
		}
		
//		System.out.println(y + " " + temp);
		int res = 0;
		while ( temp > 0 && x > 0){
			System.out.println(x+ " " + y + " " + temp);
			if(y<x){
				x = x-y;
				res = res + temp;
			}
			y>>=1;
			temp>>=1;
			
		}
		
		System.out.println(res);
		
		// x = 3
		// y = 4
		//1
		// ans = 5
	}
}
