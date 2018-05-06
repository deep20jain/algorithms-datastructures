package medium.sortAndSearch;

/**
 * Created by deep20jain on 29-04-2018.
 */
public class FindPeakElement {
    //NO need to compare with previous, as that would already be covered
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1])
                return i;
        }

        return nums.length-1;
    }

    //most optimum
    public int findPeakElement_binarySearch(int[] nums) {
        return binary(nums, 0, nums.length-1);
    }

    private int binary(int[] nums, int l, int r) {
        if(l==r)
            return l;

        int mid = l+((r-l)/2);
        if(nums[mid] > nums[mid+1])
            return binary(nums, l, mid);
        return binary(nums, mid+1, r);
    }

    // Super ugly code
    public int findPeakElement_bad(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length == 1)
            return 0;

        if(nums[0]>nums[1])
            return 0;

        for (int i = 1; i <= nums.length-2; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }

        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;

        return 0;
    }
}
