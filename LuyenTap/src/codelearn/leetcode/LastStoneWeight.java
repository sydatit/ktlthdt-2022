package codelearn.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>( (a, b) -> b - a);
        for (int item :stones) {
            queue.add(item);
        }
        while (queue.size() >= 2){
            int first = queue.poll();
            int second = queue.poll();
            if( second != first) queue.add(first - second);
        }
        if( queue.size() != 0) return queue.peek();
        return 0;
    }
}
