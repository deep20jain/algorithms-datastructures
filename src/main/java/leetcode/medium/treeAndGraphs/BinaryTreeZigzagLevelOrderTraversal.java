package leetcode.medium.treeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by deep20jain on 04-04-2018.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null) continue;
                queue.add(node.left);
                queue.add(node.right);
                if(leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0,  node.val);
                }
            }
            leftToRight = !leftToRight;
            if(!level.isEmpty()) res.add(level);
        }

        return res;
    }

    public List<List<Integer>> zigzagLevelOrder_rec(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> res, int i) {
        if(root==null)
            return;

        if(i>=res.size()) {
            res.add(new ArrayList<>());
        }

        levelOrder(root.left, res, i+1);
        levelOrder(root.right, res, i+1);
        if(i%2==0)
            res.get(i).add(root.val);
        else
            res.get(i).add(0, root.val);
    }
}
