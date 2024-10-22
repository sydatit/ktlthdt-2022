package codelearn.leetcode;

public class DeleteLeavesWithGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        DeleteLeavesWithGivenValue deleteLeavesWithGivenValue = new DeleteLeavesWithGivenValue();
        TreeNode result = deleteLeavesWithGivenValue.removeLeafNodes(root, 2);
        System.out.println(result);
    }
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if (node == null)
            return null;
        TreeNode left = removeLeafNodes(node.left, target);
        TreeNode right = removeLeafNodes(node.right, target);
        node.left = left;
        node.right = right;
        if (left == null && right == null) {
            return node.val == target ? null : node;
        } else {
            return node;
        }
    }
}
