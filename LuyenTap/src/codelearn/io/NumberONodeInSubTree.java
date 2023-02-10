package codelearn.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberONodeInSubTree {
    public static void main(String[] args) {
        NumberONodeInSubTree tree = new NumberONodeInSubTree();
        System.out.println(Arrays.toString(tree.countSubTrees(7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                "abaedcd")));
    }
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        HashMap<Integer, Integer> edgeMap = new HashMap<>();
//        int[] nodes = new int[n];
//        int[] result = new int[n];
//        for (int i = 0; i < edges.length; i++) {
//            if(edgeMap.containsKey(edges[i][0]) || edges[i][0] == 0){
//                edgeMap.put(edges[i][1], edges[i][0]);
//            }else {
//                edgeMap.put(edges[i][0], edges[i][1]);
//            }
//            nodes[edges[i][0]]++;
//            nodes[edges[i][1]]++;
//        }
//        for (int i = 0; i < n; i++) {
//            int[] labelI = new int[26];
//            if( nodes[i] == 1){
//                goRoot( result, edgeMap, labelI, labels,i );
//            }
//        }
//
//        return result;
//    }
//    private void goRoot(int[] result, HashMap<Integer, Integer> edgeMap, int[] labelI, String labels, int i) {
//        result[i] = result[i] + labelI[labels.charAt(i)- 'a'];
//
//        System.out.println(i + " -- " + labelI[labels.charAt(i)- 'a'] + " ---- " + result[i]);
//        if( edgeMap.containsKey(i)){
//            int previousNode = edgeMap.get(i);
//            labelI[labels.charAt(i)- 'a']++;
//
//
//            goRoot(result, edgeMap, labelI, labels, previousNode);
//        }
//    }
    HashMap<Integer, List<Integer>> edgeMap;
    boolean[] mark;
    int[] result;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        edgeMap = new HashMap<>();
        result = new int[n];
        mark = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            edgeMap.putIfAbsent(edges[i][0], new ArrayList<>());
            edgeMap.get(edges[i][0]).add(edges[i][1]);
            edgeMap.putIfAbsent(edges[i][1], new ArrayList<>());
            edgeMap.get(edges[i][1]).add(edges[i][0]);
        }
        travelDFS(0, labels);

        return result;
    }

    private int[] travelDFS(int i, String labels) {
        mark[i] = true;
        int[] count = new int[26];
        char charI = labels.charAt(i);
        for (Integer item :edgeMap.get(i)) {
            if( !mark[item]){
                int[] subTree = travelDFS(item, labels);
                for (int j = 0; j < 26; j++) {
                    count[j] += subTree[j];
                }
            }
        }

        result[i] = ++count[charI - 'a'];
        return count;
    }


}
