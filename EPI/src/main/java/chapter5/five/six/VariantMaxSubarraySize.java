package chapter5.five.six;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deep2 on 19-06-2017.
 */
public class VariantMaxSubarraySize {
    public static void main(String[] args) {
        Double[] A = new Double[] {310.0, 310.0, 260.0, 260.0, 260.0, 275.0, 275.0, 275.0, 275.0, 275.0 };
        List<Double> B = Arrays.asList(A);
        System.out.println(maxSubarraySize(B));
    }

    public static int maxSubarraySize(List<Double> prices) {
        double t = prices.get(0);
        int maxSize = 0;
        int globalMaxSize = 0;

        for(Double price: prices) {
            if(t == price) {
                maxSize++;
            } else {
                maxSize = 1;
            }
            t = price;
            globalMaxSize = Math.max(globalMaxSize, maxSize);
        }

        return globalMaxSize;
    }
}
