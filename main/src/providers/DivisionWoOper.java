

/**
 * DivisionWoOper
 */
public class DivisionWoOper {
    public static void main(String[] args) {
        int a = 25;
        int b = 3;
        int n = 1;

        int res = 0;

        while ( b < a){
            b <<= 1;
            n <<= 1;
        }
        // System.out.println(n);
        while (n > 0){
            if( b <= a){
                a = a-b;
                res += n;
            }
            // System.out.println(b);
            b >>= 1;
            n >>= 1;
            // System.out.println(n);
        }

        System.out.println(res);
    }
}




// a = 18
// 010010

// b = 3
// 000011-> 000110 -> 001100 - > 011000 -> 110000  = 48

// n =      000010    000100     001000 -> 010000  = 16



// a = 110 = 6      ->
// b = 001100 = 12  -> 000110 : 6
// n = 000100 = 4   -> 10 : 2


// res = 4










