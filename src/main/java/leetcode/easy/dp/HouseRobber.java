package leetcode.easy.dp;

/**
 * Created by deep20jain on 16-03-2018.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        if(nums.length==2)
            return Math.max(nums[0], nums[1]);

        int maxTillLast = Math.max(nums[0], nums[1]);
        int maxTillSecondLast = nums[0];

        for (int i = 2; i < nums.length; i++) {
            int currentMaxCandidate = nums[i]+maxTillSecondLast;
            if(currentMaxCandidate>maxTillLast) {
                maxTillSecondLast = maxTillLast;
                maxTillLast = currentMaxCandidate;
            } else {
                maxTillSecondLast=maxTillLast;
            }
        }
        return maxTillLast;
    }
}
