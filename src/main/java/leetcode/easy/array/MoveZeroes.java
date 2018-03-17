package leetcode.easy.array;

/**
 * Good One
 * Created by deep20jain on 17-03-2018.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                nums[++index]=nums[i];
            }
        }

        for (int i = index+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
