package codelearn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountTimeBinaryTreeBeInfected {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4, node9, node2);
        TreeNode node5 = new TreeNode(5, null, node4);
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node10, node6);
        TreeNode node1 = new TreeNode(1, node5, node3);
        System.out.println(amountOfTime(node1, 3));
    }
    private static int ans;

    public static int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    public static int dfs(TreeNode root, int start) {
        if (root == null) return 0;

        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        if (root.val == start) {
            ans = Math.max(leftDepth, rightDepth);
            return -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            ans = Math.max(ans, Math.abs(leftDepth - rightDepth));
            return Math.min(leftDepth, rightDepth) - 1;
        }
    }
//    private static Map<Integer, List<Integer>> adj;
//    private static int result;
//    public static int amountOfTime(TreeNode root, int start) {
//        adj = new HashMap<>();
//        rebuildAdjacency(root);
//        result = -1;
//        bfs(start);
//        return result;
//    }
//
//    private static void bfs(int start) {
//        Set<Integer> visited = new HashSet<>();
//        Queue<Integer> queue = new LinkedList<>();
//        visited.add(start);
//        queue.add(start);
//        while (!queue.isEmpty()) {
//            result++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                if (queue.isEmpty()) {
//                    break;
//                }
//                Integer u = queue.poll();
//                if (u == null) break;
//                for (Integer v: adj.get(u)) {
//                    if (!visited.contains(v)) {
//                        queue.add(v);
//                        visited.add(v);
//                    }
//                }
//            }
//        }
//    }
//
//    private static void rebuildAdjacency(TreeNode node) {
//        if (node.left != null) {
//            List<Integer> listOfNodes = adj.getOrDefault(node.val, new ArrayList<>());
//            listOfNodes.add(node.left.val);
//            adj.put(node.val, listOfNodes);
//
//            List<Integer> listOfLeftNodes = adj.getOrDefault(node.left.val, new ArrayList<>());
//            listOfLeftNodes.add(node.val);
//            adj.put(node.left.val, listOfLeftNodes);
//
//            rebuildAdjacency(node.left);
//        }
//        if (node.right != null) {
//            List<Integer> listOfNodes = adj.getOrDefault(node.val, new ArrayList<>());
//            listOfNodes.add(node.right.val);
//            adj.put(node.val, listOfNodes);
//
//            List<Integer> listOfLeftNodes = adj.getOrDefault(node.right.val, new ArrayList<>());
//            listOfLeftNodes.add(node.val);
//            adj.put(node.right.val, listOfLeftNodes);
//
//            rebuildAdjacency(node.right);
//        }
//    }
}
