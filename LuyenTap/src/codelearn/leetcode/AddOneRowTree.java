package codelearn.leetcode;

public class AddOneRowTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        AddOneRowTree addOneRowTree = new AddOneRowTree();
        TreeNode result = addOneRowTree.addOneRow(root, 1, 2);
        System.out.println(result);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth, 1);
        return root;
    }

    private void addRow(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null) {
            return;
        }
        if (currentDepth == depth - 1) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = node.left;
            newRight.right = node.right;

            node.left = newLeft;
            node.right = newRight;
            return;
        }
        addRow(node.left, val, depth, currentDepth + 1);
        addRow(node.right, val, depth, currentDepth + 1);
    }
}
