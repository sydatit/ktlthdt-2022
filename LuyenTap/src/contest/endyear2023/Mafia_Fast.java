package contest.endyear2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Mafia_Fast {
    private static ArrayList<Integer>[] adj;
    private static int[] result;
    private static int[] powers;
    private static int index;
    private static Map<Integer, int[]> queries;

    static class Node {
        int position;
        int left;
        int right;
        int value;
        public Node() {
            position = 0;
            left = 0;
            right = 0;
            value = 0;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "position=" + position +
                    ", left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        powers = new int[n + 1];
        result = new int[n + 1];
        for (int i = 1; i < powers.length; i++) {
            powers[i] = scanner.nextInt();
        }
        adj = new ArrayList[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[scanner.nextInt()].add(i + 1);
        }
        index = 1;
        queries = new HashMap<>();
        int[] arrangedPowers = new int[n + 1];

        bfs(1, arrangedPowers);
        for (int i = 1; i <= n; i++) {
            arrangedPowers[i] = powers[arrangedPowers[i]];
        }

        solve(arrangedPowers);
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void solve(int[] arr) {
        LinkedList<Node> list = new LinkedList<>();
        int[] bITree = new int[arr.length + 1];

        for (int i = 1; i < arr.length; i++) {
            Node node = new Node();
            node.value = arr[i];
            node.right = i;
            list.add(node);
        }
        queries.forEach((k, v) -> {
            Node node = new Node();
            node.position = k;
            node.left = v[0];
            node.right = v[1];
            node.value = powers[k] + 1;
            list.add(node);
        });
        list.sort((o1, o2) -> {
            if (o1.value != o2.value) return Integer.compare(o2.value, o1.value);
            return Integer.compare(o1.left, o2.left);
        });
        for (Node node : list) {
            if (node.position == 0) {
                update(bITree, arr.length, node.right);
            } else {
                int count = query(bITree, node.right) - query(bITree, node.left - 1);
                result[node.position] = count;
            }
        }
    }

    private static int query(int[] bITree, int index) {
        int count = 0;
        while (index > 0) {
            count += bITree[index];
            index -= index & -index;
        }
        return count;
    }

    private static void update(int[] bITree, int length, int index) {
        while (index <= length) {
            bITree[index] += 1;
            index += index & -index;
        }
    }

    private static void bfs(int u, int[] arrangedArr) {
        int start = index;
        for (Integer v :adj[u]) {
            bfs(v, arrangedArr);
        }
        int end = index - 1;
        if (index != start)
            queries.put(u, new int[]{start, end});
        arrangedArr[index++] = u;
    }
}