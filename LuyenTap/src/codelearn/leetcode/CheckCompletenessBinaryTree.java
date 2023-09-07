package codelearn.leetcode;

public class CheckCompletenessBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(new CheckCompletenessBinaryTree().isCompleteTree(root));
    }
    public boolean isCompleteTree(TreeNode root) {
        int count = countNode(root);
        System.out.println(count);
        return checkNode(root, 0, count);
    }

    private boolean checkNode(TreeNode root, int index, int count) {
        if(root == null)
            return true;
        if( index >= count)
            return false;
        return checkNode(root.left, index* 2 + 1, count) &&
                checkNode(root.right, index * 2 + 2, count);
    }

    private int countNode(TreeNode node) {
        if( node == null)
            return 0;
        return ( countNode(node.left) + countNode(node.right) + 1);
    }
}
