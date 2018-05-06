package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deep20jain on 18-04-2018.
 */
public class Subsets {

    // Using bits, limited by 2^n length
    public List<List<Integer>> subsets_bit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = 1 << nums.length;                                                     // #trick - power of two, Math.pow returns double
        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<n; i++) {
            temp.clear();
            for(int j=0; j<nums.length;j++) {
                if(((i>>>j)&1) == 1) {                                                // #fail  - note >>> for unsigned rotation
                    temp.add(nums[j]);
                }
            }
            res.add(new ArrayList(temp));
        }
        return res;
    }

    // Simple Iterative - copied from comments
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }

    // Recursive - 1
    public List<List<Integer>> subsets_rec(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int ind, ArrayList<Integer> temp) {
        if(ind == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        backtrack(res, nums, ind+1, temp);
        temp.add(nums[ind]);
        backtrack(res, nums, ind+1, temp);
        temp.removeIf(i -> i==nums[ind]);
    }
}
