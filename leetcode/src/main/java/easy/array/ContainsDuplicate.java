package easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by deep20jain on 17-03-2018.
 */
public class ContainsDuplicate {
    //If modification of original ds acceptable
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicate_hash(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
