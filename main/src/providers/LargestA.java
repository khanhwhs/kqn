package Code_Questions;
import java.util.*;

public class LargestA {
//	public static void main(String[] args){
//		ArrayList<ArrayList<String>> list = new ArrayList<>();
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("item1");
//		a.add("item2");
//		list.add(a);
//		a.add("item3");
//		a.add("item4");
//		list.add(a);
//		a.add("item4");
//		a.add("item5");
//		list.add(a);
//		ArrayList<String> result= largestAs(list);
//		
//		String [] re = list.toArray(new String[0]);
//		System.out.println(re);
//
//	}
//	
//	public static ArrayList<String> largestAs(ArrayList<ArrayList<String>> list)
//	{
//		
//		
//		return null;
//		
//	}
	
	static boolean wordBreak(String str)
	{
	    int size = str.length();
	 
	    // Base case
//	    if (size == 0)  return true;
	    if (dictionaryContains( str) ) return true;
	    
	    // Try all prefixes of lengths from 1 to size
	    for (int i=1; i<=size; i++)
	    {
	        // The parameter for dictionaryContains is str.substr(0, i)
	        // str.substr(0, i) which is prefix (of input string) of
	        // length 'i'. We first check whether current prefix is in
	        // dictionary. Then we recursively check for remaining string
	        // str.substr(i, size-i) which is suffix of length size-i
	    	
	    	System.out.println(" check: " + str.substring(0, i) + " and WB is: " + str.substring(i, size));
	        if (dictionaryContains( str.substring(0, i) ) &&
	            wordBreak( str.substring(i, size) ))
	        	
	        	
	            System.out.println("a word is: " + str.substring(0, i));
	        	return true;
	    }
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}
	
	private static boolean dictionaryContains(String word) {
	// TODO Auto-generated method stub
		
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream", "at", "amazon"};
			int size = dictionary.length;
			for (int i = 0; i < size; i++)
			if (dictionary[i].compareTo(word) == 0)
				return true;
			return false;
	}

	public static void main(String[] args) {

		String[][] in = new String[][]{{"item1", "item2"},{"item3", "item4"},{"item4", "item5"},{"item1", "item6"},{"item1", "item7"}};
		
		if (!wordBreak("atamazonmobilesamsung")) System.out.println("True");

	}

	/**
	 * Method used to find combine related item
	 * 
	 * @param in
	 * @return String[]
	 */
	static String[] generateItemGroup(String[][] in) {
		
		List<Set<String>> sets = new ArrayList<Set<String>>();
		
		for ( String[] i : in){
			sets.add(new LinkedHashSet<String>(Arrays.asList(i)));
		}

	    Map<String, Set<String>> resultHM = new LinkedHashMap<String, Set<String>>();
	    Map<String, Set<String>> hm = new LinkedHashMap<String, Set<String>>();

	    for (Set<String> set : sets) {

	        Set<String> totalSet = new TreeSet<String>(set);
	        for (String e : set) {
	            Set<String> inS = hm.get(e);
	            if (inS != null && !inS.isEmpty()) {
	                String first = inS.iterator().next();
	                resultHM.remove(first);
	                totalSet.addAll(inS);
	            }
	        }
	        if (!totalSet.isEmpty()) {
	            // take the first e as key and put this in resultHM
	            String first = totalSet.iterator().next();
	            resultHM.put(first, totalSet);
	            // Putting each elements relation to temp map
	            for (String e : totalSet) {
	                hm.put(e, totalSet);
	            }
	        }
	    }
	    
	    String[] result = findLargestItemGroup(resultHM.values());
	    return result;

	}

	/**
	 * Method used to find the largest item group
	 * @param itemGroups
	 * @return Set<String> largestSet
	 */
	static String[] findLargestItemGroup(Collection<Set<String>> itemGroups) {

	    int largestSetCount = 0;
	    Set<String> largestSet = null;
	    for (Set<String> set : itemGroups) {
	        if (set.size() > largestSetCount) {
	            largestSetCount = set.size();
	            largestSet = set;
	        }
	    }
	    
//	    for (Set<String> set : itemGroups) {
//            largestSetCount = (set.size() > largestSetCount)? set.size() : largestSetCount;
//            largestSet = (set.size() > largestSetCount) ? set : largestSet;
//	    }
	    String[] resultString = largestSet.toArray(new String[largestSet.size()]);
	    return resultString;
	}

}
