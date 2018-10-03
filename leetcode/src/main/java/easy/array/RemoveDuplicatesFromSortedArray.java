package easy.array;

/**
 * Created by deep20jain on 03-10-2018.
 */
public class RemoveDuplicatesFromSortedArray {
    //beats 40 pc solutions
    public int removeDuplicates(int[] nums) {
        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[x]) {
                nums[++x] = nums[i];
            }
        }
        return (x + 1);
    }
}
