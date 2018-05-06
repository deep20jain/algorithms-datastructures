package medium.array;

/**
 * Created by deep20jain on 02-04-2018.
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        //#trick - Maintain small < big, return true once we find c < small once  both small and big are set

        for(int x:nums) {
            if(x <= small) small = x;
            else if(x <= big) big = x;
            else return true;
        }

        return false;
    }
}
