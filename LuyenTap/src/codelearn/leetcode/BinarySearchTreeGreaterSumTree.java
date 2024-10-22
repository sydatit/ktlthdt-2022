package codelearn.leetcode;

public class BinarySearchTreeGreaterSumTree {
    public static void main(String[] args) {

    }
    public TreeNode bstToGst(TreeNode root) {
        totalOfChildTree(root, 0);

        return root;
    }

    private int totalOfChildTree(TreeNode node, int calculateTotalBefore) {
        if (node == null)
            return 0;
        int totalRightSide = totalOfChildTree(node.right, calculateTotalBefore);
        totalRightSide += node.val + calculateTotalBefore;
        node.val = totalRightSide;

        return totalOfChildTree(node.left, totalRightSide);
    }
}
