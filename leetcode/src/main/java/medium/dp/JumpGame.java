package medium.dp;

/**
 * Created by deep20jain on 11-05-2018.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int leftMostValid = nums.length - 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if(i+nums[i] >= leftMostValid) {
                leftMostValid = i;
            }
        }
        return leftMostValid==0;
    }


    //TLE
    public boolean canJump_dp(int[] nums) {
        if(nums==null || nums.length==0) {
            return false;
        }

        boolean[] canReachEnd = new boolean[nums.length];
        canReachEnd[nums.length-1] = true;

        for (int i = nums.length-2; i >= 0; i--) {
            int maxSteps = nums[i];
            for(int j=1; j<=maxSteps && j<nums.length;j++){
                if(canReachEnd[i+j]) {
                    canReachEnd[i] = true;
                    break;
                }
            }
        }

        return canReachEnd[0];
    }
}
