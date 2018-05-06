package medium.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * Created by deep20jain on 29-03-2018.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    //Sliding Window (O(2n) ~ O(n))
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxSetSize = 0;
        int i=0, j=0;

        while(i<n && j<n) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                j++;
                set.add(c);
                maxSetSize = maxSetSize > set.size() ? maxSetSize : set.size();
            } else {
                while (s.charAt(i)!=c) {
                    set.remove(s.charAt(i++));
                }
                i++;j++;
            }
        }

        return maxSetSize;
    }

    //Sliding Window optimized
    public int lengthOfLongestSubstring_optimized(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int n = s.length(), max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }

            max = Math.max(max, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return max;
    }

}
