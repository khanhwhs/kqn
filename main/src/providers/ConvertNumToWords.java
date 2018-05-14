// import java.util.StringBuilder;
import java.lang.StringBuilder;
/**
 * ConvertNumToWords;
 */
public class ConvertNumToWords {
    public static void main(String[] args) {
        System.out.println(convert(2222222));
    }
    public static String [] one = {"zero", "one","two","three"};
    public static String [] twenty = {"", "","twenty","thirty"};

    public static String convert(int n){
        StringBuilder sb = new StringBuilder();
       
        if (0 >= n || n <= 19){
            // System.out.println(n);
            sb.append(one[n]);
            return sb.toString();
        }
        else if( 20 >= n || n <= 99){
            sb.append(twenty[n/10]);
            sb.append(" ");
            sb.append(one[n%10]);
            return sb.toString();
        }
        else if( 100 >= n || n <= 999){
            sb.append(convert(n/100));
            sb.append(" ");
            sb.append("hundred");
            sb.append(" ");
            sb.append(convert(n%100));
            return sb.toString();
        }
        else if( 1000 >= n || n <= 999999){
            sb.append(convert(n/1000));
            sb.append(" ");
            sb.append("thousand");
            sb.append(" ");
            sb.append(convert(n%1000));
            return sb.toString();
        }
        else if( 1000000 >= n || n <= 999999999){
            sb.append(convert(n/1000000));
            sb.append(" ");
            sb.append("million");
            sb.append(" ");
            sb.append(convert(n%1000000));
            return sb.toString();
        }
        System.out.println("WOWW HERE");
        return sb.toString();
    }
    
}