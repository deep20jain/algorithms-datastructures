package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by deep20jain on 10-04-2018.
 */
public class Permutations {
    public List<List<Integer>> permute_iter(int[] nums) {
        Queue<List<Integer>> A = new LinkedList<>();
        A.add(new ArrayList<>());

        while (A.peek().size()!=nums.length) {
            List<Integer> temp = A.poll();
            for(int t:nums) {
                if(temp.contains(t))
                    continue;

                temp.add(t);
                A.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);                               //#fail - (for int lists) remove takes index as the argument, not int to remove
            }
        }
        return new ArrayList(A);
    }

    //Recursive
    public List<List<Integer>> permute_rec(int[] nums) {
        List<List<Integer>> A = new ArrayList<>();
        backtrack(A, nums, 0, new ArrayList<>());
        return A;
    }

    private void backtrack(List<List<Integer>> A, int[] nums, int ind, ArrayList<Integer> temp) {
        if(ind == nums.length) {
            A.add(new ArrayList<>(temp));                                          //#fail - make a copy instead of adding original
            return;
        }

        for(int t:nums) {
            if(temp.contains(t))
                continue;
            temp.add(t);
            backtrack(A, nums, ind+1, temp);
            temp.remove(ind);
        }
    }

}
