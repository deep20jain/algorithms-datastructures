package easy.bit;

/**
 * Created by deep20jain on 21-03-2018.
 */
public class HammingDistance {
    //stupid solution
    public int hammingDistance(int x, int y) {
        int common = 0;
        int mask = 1;
        while (x!=0 || y!=0) {
            common += ((x & mask) ^ (y & mask));
            x = x>>1;
            y = y>>1;
        }
        return common;
    }

    //it is essentially bitcount of the xor
    public int hammingDistance_bitcount(int x, int y) {
        int xor = x^y;
        int count = 0;
        while (xor!=0) {
            xor &= (xor-1);
            count++;
        }
        return count;
    }
}
