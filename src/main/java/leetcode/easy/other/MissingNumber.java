package leetcode.easy.other;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1

 Input: [3,0,1]
 Output: 2

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

    public int missingNumber_bitManipulation(int[] nums) {
        int num = nums.length;
        for (int i = 0; i < nums.length; i++) {
            num ^= i^nums[i];
        }
        return num;
    }
}
