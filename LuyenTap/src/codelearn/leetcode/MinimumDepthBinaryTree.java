package codelearn.leetcode;

public class MinimumDepthBinaryTree {
    public static void main(String[] args) {
        MinimumDepthBinaryTree test = new MinimumDepthBinaryTree();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        System.out.println(test.minDepth(root));

    }
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftCount = minDepth(root.left);
        int rightCount = minDepth(root.right);
        if(leftCount == 0 && rightCount == 0)
            return 1;
        else if(leftCount == 0)
            return rightCount + 1;
        else if( rightCount == 0)
            return leftCount + 1;
        else
            return Math.min(leftCount, rightCount) + 1;
    }

}
