package codelearn.io;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RemoveStonesMinimizeTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        RemoveStonesMinimizeTotal total = new RemoveStonesMinimizeTotal();
        System.out.println(total.minStoneSum(piles, k));
    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < piles.length; i++) {
            priorityQ.add(piles[i]);
        }
        while (k-->0){
            int head = priorityQ.poll();
            priorityQ.add( head - head/2);
        }
        return priorityQ.stream()
                .reduce(0, Integer::sum);
    }
}
/*
3
5 4 9
2
 */