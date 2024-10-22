package contest.midyear2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class HEADQUARTERS {

    private static List<Integer> adj[];
    private static int[] connectings;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCities = sc.nextInt();
        if (numberOfCities <= 2) {
            for (int i = 0; i < numberOfCities; i++) {
                System.out.println(i);
            }
        }
        adj = new List[numberOfCities];
        connectings = new int[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < numberOfCities - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            connectings[u]++;
            connectings[v]++;
            adj[u].add(v);
            adj[v].add(u);
        }
        List<Integer> headquarters = findHeadquarter(numberOfCities);
        for (int i = 0; i < headquarters.size(); i++) {
            System.out.println(headquarters.get(i));
        }
    }

    private static List<Integer> findHeadquarter(int numberOfCities) {
        List<Integer> headquarter = new ArrayList<>();
        int traveledCities = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numberOfCities; i++) {
            if (adj[i].size() == 1) {
                queue.add(i);
            }
        }
        while (traveledCities + 2 < numberOfCities) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                traveledCities++;
                for (int v : adj[u]) {
                    if (--connectings[v] == 1) {
                        queue.add(v);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            headquarter.add(queue.poll());
        }
        Collections.sort(headquarter);
        return headquarter;
    }
}
/*
4
0 1
2 1
3 1
 */