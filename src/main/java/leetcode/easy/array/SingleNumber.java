package leetcode.easy.array;

/**
 * Created by deep20jain on 17-03-2018.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber = singleNumber ^ nums[i];
        }
        return singleNumber;
    }
}
