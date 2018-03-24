package Code_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Date 01/29/2016
 * @author Tushar Roy
 *
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */
public class StringPermutation {

    public List<String> permute(char input[]) {
    	HashMap <Character, Integer> map = new HashMap<> ();
    	for (char ch: input){
    		if (map.containsKey(ch)){
    			int ct = map.get(ch)  +1;
    			map.put(ch, ct);
    		}else
    			map.put(ch, 1);
    		
    	}
    	
        char str[] = new char[map.size()];
        int count[] = new int[map.size()];
        int index = 0;
        System.out.println(map.entrySet());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
        
//        Map<Character, Integer> countMap = new TreeMap<>();
//        for (char ch : input) {
//            countMap.compute(ch, (key, val) -> {
//                if (val == null) {
//                    return 1;
//                } else {
//                    return val + 1;
//                }
//            });
//        }
//        char str[] = new char[countMap.size()];
//        int count[] = new int[countMap.size()];
//        int index = 0;
//        System.out.println(countMap.entrySet());
//        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
//            str[index] = entry.getKey();
//            count[index] = entry.getValue();
//            index++;
//        }
//        List<String> resultList = new ArrayList<>();
//        char result[] = new char[input.length];
//        permuteUtil(str, count, result, 0, resultList);
//        return resultList;
    }

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
    }
}