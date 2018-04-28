package leetcode.medium.sortAndSearch;

import java.util.*;

/**
 * Created by deep20jain on 21-04-2018.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> fqncy = new HashMap<>();
        Set<Integer>[] set = new HashSet[nums.length];

        for (int i = 0; i < nums.length; i++) {
            fqncy.put(nums[i], fqncy.getOrDefault(nums[i], 0)+1);
        }

        for(Integer i:fqncy.keySet()) {
            if(set[fqncy.get(i)-1] == null) {
                set[fqncy.get(i)-1] = new HashSet<>();
            }
            set[fqncy.get(i)-1].add(i);
        }

        for (int i = set.length-1; i >= 0; i--) {
            if(set[i]==null)
                continue;

            for (Iterator<Integer> it = set[i].iterator(); it.hasNext(); ) {
                if(res.size()==k)
                    break;

                res.add(it.next());
            }
        }

        return res;
    }
}
