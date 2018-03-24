package Basic;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
public class HashMapPratice {


//	   public static void main(String args[]) {
//
//	      /* This is how to declare HashMap */
//	      HashMap<Integer, String> hmap = new HashMap<Integer, String>();
//
//	      /*Adding elements to HashMap*/
//	      hmap.put(12, "Chaitanya");
//	      hmap.put(2, "Rahul");
//	      hmap.put(7, "Singh");
//	      hmap.put(49, "Ajeet");
//	      hmap.put(3, "Anuj");
//
//	      /* Display content using Iterator*/
//	      Set set = hmap.entrySet();
//	      Iterator iterator = set.iterator();
//	      while(iterator.hasNext()) {
//	         Map.Entry mentry = (Map.Entry)iterator.next();
//	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//	         System.out.println(mentry.getValue());
//	      }
//
//	      /* Get values based on key*/
//	      String var= hmap.get(2);
//	      System.out.println("Value at index 2 is: "+var);
//
//	      /* Remove values based on key*/
//	      hmap.remove(3);
//	      System.out.println("Map key and values after removal:");
//	      Set set2 = hmap.entrySet();
//	      Iterator iterator2 = set2.iterator();
//	      while(iterator2.hasNext()) {
//	          Map.Entry mentry2 = (Map.Entry)iterator2.next();
//	          System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
//	          System.out.println(mentry2.getValue());
//	       }
//
//	   }
	
	public static void main(String[] args) {

        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(5, "A");
        hmap.put(11, "C");
        hmap.put(4, "Z");
        hmap.put(77, "Y");
        hmap.put(9, "P");
        hmap.put(66, "Q");
        hmap.put(0, "R");

        System.out.println("Before Sorting:");
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
              Map.Entry me = (Map.Entry)iterator.next();
              System.out.print(me.getKey() + ": ");
              System.out.println(me.getValue());
        }
        
//        As we know that HashMap doesn’t preserve any order by default. 
//        If there is a need we need to sort it explicitly based on the requirement. 
//        In this tutorial we will learn how to sort HashMap by keys using TreeMap ( all key in ordered) and by values using Comparator.
        Map<Integer, String> map = new TreeMap<Integer, String>(hmap); 
        System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
             Map.Entry me2 = (Map.Entry)iterator2.next();
             System.out.print(me2.getKey() + ": ");
             System.out.println(me2.getValue());
        }
   }
}
