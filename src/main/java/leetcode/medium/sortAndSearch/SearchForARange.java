package leetcode.medium.sortAndSearch;

import java.util.Arrays;

/**
 * Created by deep20jain on 29-04-2018.
 */
public class SearchForARange {
    public static void main(String[] args) {
        Arrays.stream(new SearchForARange().searchRange(new int[]{}, 0)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{1}, 0)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{1}, 1)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{2, 2}, 2)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{1, 2, 2, 3}, 2)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(x -> System.out.print(x));
        System.out.println();
        Arrays.stream(new SearchForARange().searchRange(new int[]{7, 7, 7, 8, 8, 10}, 7)).forEach(x -> System.out.print(x));
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int a = binarySearch(nums, 0, nums.length-1, target);

        if(a==-1)
            return new int[]{-1, -1};

        int b = leftmost(nums, a, target);
        int c = rightmost(nums, a, target);

        return new int[]{b, c};
    }

    private int leftmost(int[] nums, int index, int x) {
        int res = index;
        int l = index;

        do {
            res = l;
            l = binarySearch(nums, 0, res-1, x);
        } while (l!=-1);

        return res;
    }

    private int rightmost(int[] nums, int index, int x) {
        int res = index;
        int r = index;

        do {
            res = r;
            r = binarySearch(nums, res+1, nums.length-1, x);
        } while (r!=-1);

        return res;
    }

    public int binarySearch(int[] nums, int start, int end, int x) {
        if(nums==null || nums.length==0)
            return -1;

        int l = start, r = end;
        while (l <= r) {
            int mid = l + ((r-l)/2);
            if(nums[mid] == x) return mid;
            else if(nums[mid] < x) l = mid+1;
            else r = mid - 1;
        }

        return -1;
    }
}
