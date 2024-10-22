package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100 ,90 ,90 ,80 ,75 ,60);
        List<Integer> player = Arrays.asList(50,65,77,90,102);

        System.out.println(climbingLeaderboard(ranked, player));
    }

    static class Player {
        private int ranked;
        private int score;
        public Player(int ranked, int score) {
            this.ranked = ranked;
            this.score = score;
        }
        @Override
        public String toString() {
            return ranked + " " + score;
        }
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        Stack<Player> stack = new Stack<>();
        Collections.sort(ranked);
        List<Integer> result = new ArrayList<>();
        int currentRank = 1;
        stack.push(new Player(currentRank, ranked.get(ranked.size() - 1)));
        for (int i = ranked.size() - 2; i >= 0; i--) {
            if (!Objects.equals(ranked.get(i), ranked.get(i + 1))) currentRank++;

            stack.push(new Player(currentRank, ranked.get(i)));
        }

        for (int i = 0; i < player.size(); i++) {
            int myScore = player.get(i);
            while (!stack.empty() && myScore >= stack.peek().score) {
                stack.pop();
            }
            if (!stack.empty()) {
                Player higerPlayer = stack.peek();
                result.add(higerPlayer.ranked + 1);
            } else {
                result.add(1);
            }
        }
        // result.forEach(item -> System.out.println(item));
        return result;
    }
}
