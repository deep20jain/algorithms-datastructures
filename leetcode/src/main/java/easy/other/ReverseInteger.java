package easy.other;

/**
 * Created by deep20jain on 21-03-2018.
 */
public class ReverseInteger {
    /**
     * Complicated approach
     *
     * #trick:  c=a+b overflows -> If a > MAX_INT-b
     * #trick:  c=a*b overflows -> If c/b!=a
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int sign = 1;
        if(x<0) {
            sign = -1;
            x *=-1;
        }
        int n = Integer.toString(x).length();
        int res = 0;

        while (x!=0) {
            int lsb = x%10;
            int power = pow(10, n-1);
            int toAdd = lsb*power;
            if(toAdd/power!=lsb)
                return 0;
            if(res> Integer.MAX_VALUE - toAdd)
                return 0;
            res = res+toAdd;
            x=x/10;
            n--;
        }

        return res*sign;
    }

    public int reverse_simple(int x) {
        int result = 0;
        while (x!=0) {
            int tail = x%10;
            int newResult = result*10+tail;

            if((newResult-tail)/10!=result) return 0;
            result = newResult;
            x = x/10;
        }
        return result;
    }


    private int pow(int i, int n) {
        int res = 1;
        for (int j = 0; j < n; j++) {
            res *= i;
        }
        return res;
    }
}
