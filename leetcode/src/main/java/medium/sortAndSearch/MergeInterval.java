package medium.sortAndSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deep20jain on 29-04-2018.
 */
public class MergeInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0)
            return new ArrayList<>();

        intervals.sort(this::compare);

        List<Interval> res = new ArrayList<>();
        Interval p = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval c = intervals.get(i);
            if(overlap(p, c)) {
                p = merge(p, c);
            } else{
                res.add(p);
                p = c;
            }
        }

        res.add(p);

        return res;
    }

    private boolean overlap(Interval x, Interval y) {
        if(y.start >= x.start && y.start <=x.end) {
            return true;
        }
        return false;
    }

    private Interval merge(Interval x, Interval y) {
        Interval z = new Interval();
        z.start = x.start;
        z.end = x.end >= y.end ? x.end : y.end;
        return z;
    }

    private int compare(Interval x, Interval y) {
        if(x.start > y.start)
            return 1;

        if(x.start < y.start)
            return -1;

        return 0;
    }
}
