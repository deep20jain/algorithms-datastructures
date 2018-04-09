package leetcode.medium.treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by deep20jain on 07-04-2018.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect_lessSpace(TreeLinkNode root) {
        if(root==null) return;

        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left!=null) {
            cur = pre;
            while(cur!=null) {
                cur.left.next = cur.right;
                if(cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeLinkNode pre = poll(queue);
            for (int i = 1; i < n; i++) {
                TreeLinkNode cur = poll(queue);
                pre.next = cur;
                pre = cur;
            }
        }
    }

    private TreeLinkNode poll(Queue<TreeLinkNode> queue) {
        TreeLinkNode node = queue.poll();
        if(node.left!=null) queue.add(node.left);
        if(node.right!=null) queue.add(node.right);
        return node;
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int val){this.val = val;}
    }
}
