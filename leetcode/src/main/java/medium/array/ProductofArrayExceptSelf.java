package medium.array;

/**
 * Created by deep20jain on 01-11-2018.
 */
public class ProductofArrayExceptSelf {

    //with extra space
    public int[] productExceptSelf(int[] nums) {
        int[] productOfNumsToLeft = new int[nums.length];
        int[] productOfNumsToRight = new int[nums.length];
        int[] res = new int[nums.length];

        productOfNumsToLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productOfNumsToLeft[i] = productOfNumsToLeft[i-1]*nums[i-1];
        }

        productOfNumsToRight[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0 ; i--) {
            productOfNumsToRight[i] = productOfNumsToRight[i+1]*nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = productOfNumsToLeft[i] * productOfNumsToRight[i];
        }

        return res;
    }

    //without extra space
    public int[] productExceptSelf_optimized(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            res[i] = res[i]*right;
            right = right*nums[i];
        }

        return res;
    }
}
