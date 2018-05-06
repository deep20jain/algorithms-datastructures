package easy.bit;

/**
 * Created by deep20jain on 21-03-2018.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;                            // Note Order
            res = res | lsb;
            res <<= 1;
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits_jdk(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }

}
