package leetcode.easy.other;

/**
 * Created by deep20jain on 23-03-2018.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
