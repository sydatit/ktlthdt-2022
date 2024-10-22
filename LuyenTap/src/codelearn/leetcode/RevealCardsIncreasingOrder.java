package codelearn.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RevealCardsIncreasingOrder {
    public static void main(String[] args) {
        RevealCardsIncreasingOrder revealCardsIncreasingOrder = new RevealCardsIncreasingOrder();
        int[] deck = {1, 3, 5, 11, 13, 17, 19};
        int[] result = revealCardsIncreasingOrder.deckRevealedIncreasing(deck);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(i);
        }
        int i = 0;
        while (!deque.isEmpty()) {
            result[deque.pollFirst()] = deck[i++];
            if (!deque.isEmpty()) {
                deque.add(deque.pollFirst());
            }
        }
        return result;
    }
}
