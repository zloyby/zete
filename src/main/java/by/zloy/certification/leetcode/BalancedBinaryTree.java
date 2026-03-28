package by.zloy.certification.leetcode;

import static by.zloy.certification.leetcode.InvertBinaryTree.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree invertBinaryTree = new BalancedBinaryTree();

        TreeNode r0 = getTreeNodeForTrue();
        System.out.println("Is balanced: " + invertBinaryTree.isBalanced(r0));

        TreeNode r1 = getTreeNodeForFalse();
        System.out.println("Is balanced: " + invertBinaryTree.isBalanced(r1));
    }

    private static TreeNode getTreeNodeForTrue() {
        TreeNode l2_l1 = new TreeNode(3);
        TreeNode l2_l2 = new TreeNode(3);
        TreeNode l1_l1 = new TreeNode(2, l2_l1, l2_l2);
        TreeNode l1_r2 = new TreeNode(2);
        return new TreeNode(1, l1_l1, l1_r2);
    }

    private static TreeNode getTreeNodeForFalse() {
        TreeNode l3_l1 = new TreeNode(4);
        TreeNode l3_l2 = new TreeNode(4);
        TreeNode l2_l1 = new TreeNode(3, l3_l1, l3_l2);
        TreeNode l2_l2 = new TreeNode(3);
        TreeNode l1_l1 = new TreeNode(2, l2_l1, l2_l2);
        TreeNode l1_r2 = new TreeNode(2);
        return new TreeNode(1, l1_l1, l1_r2);
    }

    public boolean isBalanced(TreeNode root) {
        int maxHeight = height(root);
        System.out.println("Max length: " + maxHeight);
        return maxHeight != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        System.out.println("Left: " + leftHeight + " ; Right: " + rightHeight);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        // exclude as difference is more than 1, so tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
