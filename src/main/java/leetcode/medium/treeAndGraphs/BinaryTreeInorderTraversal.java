package leetcode.medium.treeAndGraphs;

import java.util.*;

/**
 * Created by deep20jain on 02-04-2018.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            addLeftTreeToStack(stack, cur);
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
        }

        return result;
    }

    private void addLeftTreeToStack(Stack stack, TreeNode root) {
        TreeNode n = root;
        while (n != null) {
            stack.add(n);
            n = n.left;
        }
    }

    // Morris Traversal with threaded binary tree
    public List<Integer> inorderTraversal_morris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur!=null) {
            if(cur.left==null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right!=null && pre.right!=cur) {
                    pre = pre.right;
                }

                if(pre.right==null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    result.add(pre.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}