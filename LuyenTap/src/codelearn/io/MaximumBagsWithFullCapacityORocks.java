package codelearn.io;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumBagsWithFullCapacityORocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] capacity = new int[n];
        int[] rocks = new int[n];
        int additionalRocks = 0;
        for (int i = 0; i < n; i++) {
            capacity[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            rocks[i] = scanner.nextInt();
        }
        additionalRocks = scanner.nextInt();
        MaximumBagsWithFullCapacityORocks rock = new MaximumBagsWithFullCapacityORocks();
        System.out.println(rock.maximumBags(capacity, rocks, additionalRocks));

    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        int length = capacity.length;
        PriorityQueue<Integer> priorityQ = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            int remain = capacity[i] - rocks[i];
            if( remain == 0){
                result++;
            }else {
                priorityQ.add(remain);
            }
        }
        while (additionalRocks >= 0 && !priorityQ.isEmpty()){
            int head = priorityQ.poll();
            if( additionalRocks >= head )
        }
        return result;
    }
}
