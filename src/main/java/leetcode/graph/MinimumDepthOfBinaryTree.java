package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by deep20jain on 11-03-2018.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth_bfs(TreeNode root) {
        if(root==null)
            return 0;

        int result = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i=0;i<n;i++) {
                TreeNode node = queue.poll();
                if(node.left==null && node.right==null) return result;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            result++;
        }
        return result;
    }

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null && root.left==null) return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left==0) return right+1;
        if(right==0) return left+1;
        return Math.min(left, right) +1;
    }

    //more optimised dfs
    public class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        }
    }
}
