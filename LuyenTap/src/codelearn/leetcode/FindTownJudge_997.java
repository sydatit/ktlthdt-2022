package codelearn.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTownJudge_997 {
    public static void main(String[] args) {
        System.out.println((new FindTownJudge_997()).findJudge(3,
                new int[][]{
                        {1, 3},
                        {2, 3},
                        {3, 1}
                }));
    }
    public int findJudge(int n, int[][] trust) {
        if( trust.length == 0 && n == 1)
            return 1;
        HashMap<Integer, Integer> trustMap = new HashMap<>();
        Set<Integer> peopleSet = new HashSet<>();
        for (int[] item :trust) {
            trustMap.put(item[1], trustMap.getOrDefault(item[1], 0) + 1);
            peopleSet.add(item[0]);
        }
        for (Map.Entry<Integer, Integer> entry :trustMap.entrySet()) {
            if( entry.getValue() == n - 1 && !peopleSet.contains(entry.getKey())){
                return entry.getKey();
            }
        }
        return -1;
    }

}
