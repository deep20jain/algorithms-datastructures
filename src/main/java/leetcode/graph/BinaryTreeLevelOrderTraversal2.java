package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by deep20jain on 10-03-2018.
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int n = queue.size();
            for (int i=0;i<n;i++) {
                TreeNode node = queue.poll();
                if(node!=null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(!level.isEmpty())
                result.add(0, level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom_dfs(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(root, result, 0);
        return  result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int i) {
        if(root == null) return;
        if(i >= result.size())
            result.add(0, new LinkedList<Integer>());

        dfs(root.left, result, i+1);
        dfs(root.right, result, i+1);

        result.get(result.size()-1-i).add(root.val);
    }

}
