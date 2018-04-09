package leetcode.medium.treeAndGraphs;

import java.util.Stack;

/**
 * Created by deep20jain on 08-04-2018.
 */
public class KthSmallestElementInBST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest_recur(TreeNode root, int k) {
        if(root==null) return 0;

        count = 0;
        result = 0;

        helper(root, k);

        return result;
    }

    private void helper(TreeNode root, int k) {
        if(root==null) return;

        helper(root.left, k);
        count++;
        if(count==k) {
            result = root.val;
            return;
        }

        helper(root.right, k);
    }

    public int kthSmallest_iterative(TreeNode root, int k) {
        if(root==null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int i = 0;
        while ( cur!=null || !stack.isEmpty() ) {
            addLeftTreeToStack(stack, cur);
            TreeNode node = stack.pop();
            i++;
            if(i==k) return node.val;
            cur = cur.right;
        }

        return 0;
    }
    private void addLeftTreeToStack(Stack stack, TreeNode root) {
        TreeNode n = root;
        while (n != null) {
            stack.add(n);
            n = n.left;
        }
    }
}
