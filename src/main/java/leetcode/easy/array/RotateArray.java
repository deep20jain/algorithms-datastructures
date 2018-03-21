package leetcode.easy.array;

/**
 * Created by deep20jain on 19-03-2018.
 */
public class RotateArray {
    //Brute Force
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp=nums[nums.length-1];
            for (int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    //Extra Array
    public void rotate_extraArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i+k)%n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    public void rotate_juggling(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int count = 0;

        for (int i = 0; count < n ; i++) {
            int start = i;
            int pre = nums[i];
            int next = i;

            do {
                next = (next+k) % n;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                count++;
            } while (next != start);
        }
    }

    public void rotate_byreversing(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;j--;
        }
    }


}
