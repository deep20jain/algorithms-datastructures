package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deep20jain on 24-11-2018.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = -1* (C[i] + D[j]);
                if(map.containsKey(sum)) {
                    res+=map.get(sum);
                }
            }
        }
        return res;
    }
}
