package contest.endyear2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mafia {
    private static ArrayList<Integer>[] adj;
    private static int[] result;
    private static int[] powers;
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
//        bfs(1);
        dfs(1, powers[1], powers[1], new ArrayList<>());
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int dfs(int u, long min, long max, List<Integer> list) {
        long tempMin = Math.min(powers[u], min);
        long tempMax = Math.max(powers[u], max);
        int count = 0;
        int numberOfGreater;
        List<Integer> potentialPowers = new ArrayList<>();
        for (Integer v : adj[u]) {
            count += dfs(v, tempMin, tempMax, potentialPowers);
        }

        numberOfGreater = count;
        if (min < powers[u] && powers[u] <= max)
            list.add(powers[u]);

        for (Integer v : potentialPowers) {
            if ( min < v && v <= max ) {
                list.add(v);
            }
            if (v > powers[u]) numberOfGreater++;
        }
        result[u] = numberOfGreater;
        count += powers[u] > max ? 1 : 0;
        return count;
    }

    private static List<Integer> dfs(int u) {
        List<Integer> list = new ArrayList<>();
        for (Integer v : adj[u]) {
            list.addAll(dfs(v));
        }
        int count = (int) list.stream()
                .filter(member -> member > powers[u]).count();
        result[u] += count;
        list.add(powers[u]);
        return list;
    }
}

/*
5
30
40
10
20
50
1
1
2
3

8
30
40
10
20
50
70
30
80
1
1
2
3
5
6
6
 */