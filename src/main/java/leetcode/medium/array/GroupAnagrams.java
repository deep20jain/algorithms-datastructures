package leetcode.medium.array;

import java.util.*;

/**
 * Created by deep20jain on 28-03-2018.
 */
public class GroupAnagrams {
    //With sorting - O(NKlogK) time
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chr = strs[i].toCharArray();
            Arrays.sort(chr);
            String sorted = new String(chr);                                        // Note - not toString()

            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());

            map.get(sorted).add(strs[i]);
        }

        for(List<String> s : map.values()) {
            res.add(s);
        }
        return res;
    }

    public List<List<String>> groupAnagrams_woSorting(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            char[] chr = strs[i].toCharArray();

            for (char c:chr) {
                count[c - 'a']++;
            }

            StringBuilder b = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                b.append(count[j]);
            }

            String charCount = b.toString();
            if(!map.containsKey(charCount))
                map.put(charCount, new ArrayList<>());

            map.get(charCount).add(strs[i]);
        }

        for(List<String> s : map.values()) {
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
