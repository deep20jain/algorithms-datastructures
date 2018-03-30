package leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique
 triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * Created by deep20jain on 24-03-2018.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threesum = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            List<List<Integer>> twosum = twoSum(nums, i+1, nums.length-1, 0-nums[i]);
            if(twosum.isEmpty())
                continue;
            for(List<Integer> list: twosum) {
                list.add(0, nums[i]);
                threesum.add(list);
            }
        }
        return threesum;
    }


    // #trick - if the array is sorted then following technique can be used to find pair sums easily
    private List<List<Integer>> twoSum(int[] nums, int i, int j, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int m = i;
        int n = j;
        while (m<n){
            if(nums[m]+nums[n]==sum) {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[m]);ans.add(nums[n]);
                res.add(ans);
                m++;n--;
                while(nums[m]==nums[m-1] && m<n) m++;
                while(nums[n]==nums[n+1] && m<n) n--;
            } else if((nums[m]+nums[n])<sum) {
                m++;
            } else{
                n--;
            }
        }
        return res;
    }
}
