package Code_Questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrings {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            //System.out.println("ans is: " + ans + " ----i is: " + i + " ----j is: " + j );
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        boolean[] chars = new boolean[256];
        int slow = 0, current = 0, ans = 0;
        
        //Slide window
        while (current<s.length()) {
            if (!chars[s.charAt(current)]) {
                chars[s.charAt(current)] = true;
                current++;
                ans = Math.max(ans, current-slow);
            }
            else {
                chars[s.charAt(slow)] = false;
                slow++;
            }
            
            System.out.println("ans is: " + ans + " ----current is: " + current + " ----slow is: " + slow + "---s.length():" + s.length() );
        }

        return ans;
    }
    
    public static void main(String[] args) {
    	
    	LongestSubstrings newL = new LongestSubstrings();
    	
    	System.out.println(newL.lengthOfLongestSubstring("aabcc"));

    	System.out.println(newL.lengthOfLongestSubstring2("aabcc"));
    }

}
