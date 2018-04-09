package leetcode.medium.treeAndGraphs;

import java.util.Arrays;

/**
 * Created by deep20jain on 04-04-2018.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    private TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps>pe || is>ie)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int left = find(root.val, inorder);
        int noOfElementsToLeft = left-is;
        int noOfElementsToRight = ie-left;
        root.left  = build(preorder, inorder, ps+1, ps+noOfElementsToLeft, is, left-1);
        root.right = build(preorder, inorder, ps+noOfElementsToRight+1, pe, left+1, ie);
        return root;
    }

    private int find(int root, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i]==root) return i;
        }
        return -1;
    }
}
