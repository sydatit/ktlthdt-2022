package contest.endyear2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FenwichTree {
    static class Node{
        int pos;
        int l;
        int r;
        int val;

        public Node() {
            this.pos = 0;
            this.l = 0;
            this.r = 0;
            this.val = 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] query = new int[q][3];
        for (int i = 0; i < q; i++) {
            query[i][0] = scanner.nextInt();
            query[i][1] = scanner.nextInt();
            query[i][2] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(countGreaterElements(arr, query)));
    }

    private static int[] countGreaterElements(int[] arr, int[][] queries) {
        int n = arr.length;
        int q = queries.length;
        int[] bITree = new int[n + 1];
        int[] ans = new int[q + 1];
        Node[] nodes = new Node[n + q + 1];

        for (int i = 0; i < n + q + 1; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i <= n; i++) {
            nodes[i].val = arr[i - 1];
            nodes[i].r = i;
        }

        for (int i = n + 1; i <= n + q; i++) {
            nodes[i].pos = i - n;
            nodes[i].l = queries[i - n - 1][0];
            nodes[i].r = queries[i - n - 1][1];
            nodes[i].val = queries[i - n - 1][2];
        }

        Arrays.sort(nodes, 1, n + q + 1, (o1, o2) -> {
            if (o1.val != o2.val) return Integer.compare(o2.val, o1.val);
            return Integer.compare(o1.l, o2.l);
        });
        for (int i = 1; i <= n + q; i++) {
            if (nodes[i].pos == 0)
                update(bITree, n, nodes[i].r);
            else {
                int count = query(bITree, nodes[i].r) - query(bITree, nodes[i].l - 1);
                ans[nodes[i].pos] = count;
            }
        }

        return ans;
    }

    private static int query(int[] biTree, int index) {
        int res = 0;
        while (index > 0) {
            res += biTree[index];
            index -= index & -index;
        }
        return res;
    }

    private static void update(int[] bITree, int n, int index) {
        while (index <= n) {
            bITree[index] += 1;
            index += index & -index;
        }
    }

}
/*
8
20 40 30 80 70 50 10 30
3
0 6 30
2 5 10
0 0 40
4, 2, 7, 8, 6, 5, 3, 1
1 - [0, 6]
2 - [0, 0]
3 - [2, 5]
5 - [2, 4]
6 - [2, 3]

--- TEST CASE 1 ---
8
20 40 30 80 70 50 10 30
3
1 7 30
3 6 10
1 1 40

KQ: 5, 4, 0
--- TEST CASE 2 ---
8
20 40 30 80 70 50 10 30
2
2 3 70
2 4 50
--- TEST CASE 3 ---
8
20 40 30 80 70 50 10 30
3
1 7 31
3 6 11
1 1 41

KQ: 5, 4, 1
 */