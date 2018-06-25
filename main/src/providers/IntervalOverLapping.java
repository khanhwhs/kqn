
import java.*;
/**
 * IntervalOverLapping
 */
public class IntervalOverLapping {
    // public static void main(String[] args) {
    //     int arr[][] =  { {6,8} , {1,9}, {2,4}, {4,7}};
    //     Arrays.sort(arr, new Comparator<int[]>() {
    //         public int compare(int[] a, int[] b) {
    //             return a[0] - b[0];
    //         }
    //     });

    //     for ( int [] a : arr){
    //         System.out.println( a[0]);
    //     }
    // }

    public static void main(String[] args) {
        TreeMap tmap = new TreeMap();
        Scanner scanner = new Scanner (System.in);
        boolean printReport = false;
        while(!printReport) {
          System.out.println("Enter price ");
          double price = scanner.nextDouble();
    
          LocalDateTime now = LocalDateTime.now();
          tmap.put(now, price);
          System.out.println("Record has been inserted at " +now);
    
          System.out.println("Print report ? Y / N");
          if (Character.toUpperCase(scanner.next().charAt(0)) == 'Y') {
            printReport = true;
          }
        }
    
        List keys = new ArrayList();
    
        keys.addAll(tmap.keySet());
    
        // keys.forEach((key)-&gt; 
        // for()
        System.out.println(keys.toString());
      }
    
}