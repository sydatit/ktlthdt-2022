package codelearn.leetcode;

public class SumRootLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootLeafNumbers sumRootLeafNumbers = new SumRootLeafNumbers();
        System.out.println(sumRootLeafNumbers.sumNumbers(root));
    }
    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sum = 0;
        buildPathNode(root, 0);
        return sum;
    }

    private void buildPathNode(TreeNode node, int initialValue) {
        if (node == null)
            return;
        int number = initialValue * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += number;
        }
        if (node.left != null) {
            buildPathNode(node.left, number);
        }
        if (node.right != null) {
            buildPathNode(node.right, number);
        }
    }
}
