package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        BalanceBinarySearchTree balanceBinarySearchTree = new BalanceBinarySearchTree();
        TreeNode result = balanceBinarySearchTree.balanceBST(root);
        System.out.println(result);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> listNodes = new ArrayList<>();
        inOrder(root, listNodes);

        return buildTree( 0, listNodes.size(), listNodes);
    }

    private TreeNode buildTree(int l, int r, List<Integer> listNodes) {
        if (l >= r) {
            return null;
        }
        int m = (r + l) / 2;
        TreeNode node = new TreeNode(listNodes.get(m));
        node.left = buildTree(l, m, listNodes);
        node.right = buildTree(m + 1, r, listNodes);
        return node;
    }

    private void inOrder(TreeNode node, List<Integer> listNodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, listNodes);
        listNodes.add(node.val);
        inOrder(node.right, listNodes);
    }
}
