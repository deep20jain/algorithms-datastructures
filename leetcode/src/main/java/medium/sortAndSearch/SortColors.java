package medium.sortAndSearch;

/**
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 * Created by deep20jain on 21-04-2018.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int red = -1;
        int blue = nums.length;
        int n = nums.length;
        int i=0;

        while(i<n) {
            if(nums[i]==0 && i>(red+1)) {
                swap(++red, i, nums);
                continue;
            }

            if(nums[i]==2 && i<(blue-1)){
                swap(--blue, i, nums);
                continue;
            }

            i++;
        }
    }

    private void swap(int p, int n, int[] nums) {
        int t = nums[p];
        nums[p]=nums[n];
        nums[n]=t;
    }
}
