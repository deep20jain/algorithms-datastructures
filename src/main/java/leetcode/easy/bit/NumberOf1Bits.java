package leetcode.easy.bit;

/**
 * Created by deep20jain on 21-03-2018.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight_tle(int n) {
        int count = 0;
        while(n!=0) {
            int c = n & 1;
            if(c == 1)
                count++;
            n = n>>1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n & mask) !=0)
                count++;
            mask = mask << 1;
        }
        return count;
    }

    // #trick: n & (n-1) clears the least significant set bit
    public int hammingWeight_bitManipulation(int n) {
        int count = 0;
        for (int i = 0; i < 32 && n!=0; i++) {
            count++;
            n = n & (n-1);
        }
        return count;
    }

}
