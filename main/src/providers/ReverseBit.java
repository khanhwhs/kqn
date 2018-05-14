// package providers;
public class ReverseBit{
    public static void main(String[] args) {
        int n = 6;
        int target = 32+64;
        int res = 0;

        for( int i = 0; i<8; i++){
            res <<=i;
            if( (n &(1<<i)) != 0) res|=1;
        }

        System.out.println("Hello BABY");
    }
}



// // 00000110 -- >01100000

// res = 000001100
// i = 2