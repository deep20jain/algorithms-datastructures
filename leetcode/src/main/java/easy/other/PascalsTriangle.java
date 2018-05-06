package easy.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deep20jain on 22-03-2018.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        if(numRows<=0){
            return res;
        }

        if(numRows==1){
            inner.add(1);
            res.add(inner);
            return res;
        }

        List<List<Integer>> preRes = generate(numRows-1);
        List<Integer> pre = preRes.get(preRes.size()-1);
        inner.add(1);
        for (int i = 1; i < pre.size(); i++) {
            inner.add(pre.get(i)+pre.get(i-1));
        }
        inner.add(1);
        res.addAll(preRes);
        res.add(inner);
        return res;
    }

    public List<List<Integer>> generate_iter(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        if(numRows<=0)
            return res;
        inner.add(1);
        res.add(inner);
        if(numRows==1){
            return res;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = res.get(i-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j)+pre.get(j-1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
