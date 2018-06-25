/**
 * ZeroOneQuestion
 * A string consists of ‘0’, ‘1’ and '?'. 
 * The question mark can be either '0' or '1'. Find all possible combinations for a string.
 */

public class ZeroOneQuestion {
    public static void main(String[] args) {
        String s = "001?1010?0111?0?";
        String s2 = "????";
        char [] arr = s2.toCharArray();
        print(arr,0);
        // 2^3 = 8;

        // 001??
        // ???
        // 000
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111


    }

    public static void print(char [] str, int index){
        if( str.length == index){
            for(char c: str){
                System.out.print(c);
            }
            System.out.println();
        }else{
            if(str[index] != '?') print(str, index+1);
            else{
                // replace '?' by '0' and recurse
                str[index] = '0';
                print(str, index+1);
                // replace '?' by '1' and recurse
                str[index] = '1';
                print(str, index+1);
                // NOTE: Need to backtrack as string
            // is passed by reference to the
            // function
                str[index] = '?';
            }
        }
    }
    
}

// ????
// 0???
// 00??
// 001?
// 001?