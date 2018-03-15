package leetcode.easy.dp;

/**
 * Created by deep20jain on 15-03-2018.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int[] maxTill = new int[nums.length];
        maxTill[0] = nums[0];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxTill[i] = Math.max(maxTill[i-1]+nums[i], nums[i]);
            max = Math.max(max, maxTill[i]);
        }

        return max;
    }
}
