package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        FindEventualSafeStates test = new FindEventualSafeStates();
        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        System.out.println(test.eventualSafeNodes(graph));
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        List<Integer> terminalNode = new ArrayList<>();
        int i = 0;
        for (int[] graphI :graph) {
            if(graphI.length == 0){
                terminalNode.add(i);
            }
            i++;
        }
        boolean isChanged = true;
        while (isChanged){
            isChanged = false;
            i = 0;
            for (int[] graphI :graph) {
                long count = Arrays.stream(graphI).filter(item-> !terminalNode.contains(item) && !result.contains(item))
                        .count();
                if(count == 0 && !result.contains(i)){
                    result.add(i);
                    isChanged = true;
                }
                i++;
            }
        }
        return result.stream().sorted().collect(Collectors.toList());
    }
}
