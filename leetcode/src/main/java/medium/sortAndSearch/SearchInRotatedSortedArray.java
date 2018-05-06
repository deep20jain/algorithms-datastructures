package medium.sortAndSearch;

/**
 * Created by deep20jain on 30-04-2018.
 */
public class SearchInRotatedSortedArray {
    // #beauty
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;

        int l =0;
        int h = nums.length-1;

        while (l<=h) {
            int mid = l + ((h-l)/2);

            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]) {
                if(target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else
                    l = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }

        return -1;
    }

    //Unnecessarily long
    public int search_bloated(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;

        int l=0, r=nums.length-1;
        while (l<r) {
            int mid = l + ((r-l)/2);
            if(nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }

        int pivot = l;

        if(target>=nums[pivot] && target<=nums[nums.length-1]) {
            return binary(nums, pivot, nums.length-1, target);
        }

        return binary(nums, 0, pivot-1, target);
    }

    private int binary(int[] nums, int low, int high, int target) {
        int l = low;
        int h = high;

        while (l<=h) {
            int mid = l + ((h-l)/2);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }
}
