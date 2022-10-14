package nganxep;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class T225_GiaTriNhoNhatCuaXau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat-->0){
            int k = scanner.nextInt();
            String inputStr = scanner.next();
            System.out.println(solve(inputStr, k));
        }
    }

    private static long solve(String inputStr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] charInt = new int[26];
        for (int i = 0; i < inputStr.length(); i++) {
            charInt[inputStr.charAt(i) - 'A']++;
        }
        Arrays.stream(charInt)
                .filter( item -> item != 0)
                .forEach(queue::add);
        while (k != 0){
            Integer firstEle = queue.poll();
            queue.add(--firstEle);
            k--;
        }
        AtomicLong res = new AtomicLong();
        queue.forEach( item -> res.addAndGet((long) Math.pow(item, 2)));
        return res.get();
    }
}
