package codelearn.leetcode;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {

        return helper(root, root);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
