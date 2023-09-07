package codelearn.leetcode;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root.left == null && root.right == null){
            return 1;
        }
        int max = Integer.MIN_VALUE;

        if( root.left != null) max = Math.max(max, maxDepth(root.left));
        if( root.right != null) max = Math.max(max, maxDepth(root.right));

        return max + 1;
    }
}
