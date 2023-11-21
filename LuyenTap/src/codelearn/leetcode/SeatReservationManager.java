package codelearn.leetcode;

import java.util.PriorityQueue;

public class SeatReservationManager {
    public static void main(String[] args) {

    }

    class SeatManager {
        private PriorityQueue<Integer> reservationQueue;
        private int currentReservation;
        public SeatManager(int n) {
            reservationQueue = new PriorityQueue<>(n);
            currentReservation = 1;
        }

        public int reserve() {
            if (reservationQueue.isEmpty()) {
                return currentReservation++;
            } else {
                return reservationQueue.poll();
            }
        }

        public void unreserve(int seatNumber) {
            reservationQueue.add(seatNumber);
        }
    }
}
