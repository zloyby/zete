package by.zloy.certification.leetcode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode l1_l1 = new TreeNode(11);
        TreeNode l1_r2 = new TreeNode(12);
        TreeNode l1 = new TreeNode(1, l1_l1, l1_r2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r0 = new TreeNode(2, l1, r1);
        TreeNode result = invertBinaryTree.invertTree(r0);
        System.out.println(result);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
