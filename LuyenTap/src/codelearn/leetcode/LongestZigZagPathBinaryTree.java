package codelearn.leetcode;

public class LongestZigZagPathBinaryTree {
    public static void main(String[] args) {

    }
    public int longestZigZag(TreeNode root) {
        return Math.max(helper(root.left, 0), helper(root.right, 1));
    }

    private int helper(TreeNode node, int isRightDirection) {
        if( node == null)
            return 0;
        return 0;
    }
}
