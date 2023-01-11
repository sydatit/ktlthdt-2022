package codelearn.io;

import java.util.*;

public class MinimumTimeCollectApple {
    public static void main(String[] args) {
        MinimumTimeCollectApple apple = new MinimumTimeCollectApple();
        System.out.println( apple.minTime(
                7,
                new int[][]{ {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}
                , new ArrayList<>(Arrays.asList(false,false,true,false,false,true,false))
        ));
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if( map.containsKey(edges[i][0]) || edges[i][0] == 0 ){
                map.put(edges[i][1],edges[i][0] );
                System.out.println(edges[i][1] + " " + edges[i][0] );
            }
            else{
                map.put(edges[i][0],edges[i][1] );
                System.out.println(edges[i][0] + " " + edges[i][1] );
            }
        }
        Set<Integer> vertexs = new HashSet<>();
        for (int i = 0; i < hasApple.size(); i++) {
            if( hasApple.get(i).equals(true) && i != 0){
                goRoot(map, vertexs, i);
            }
        }
//        System.out.println(vertexs);
        if( vertexs.size() == 0)
            return 0;
        return vertexs.size()*2;
    }

    private void goRoot(Map<Integer, Integer> map, Set<Integer> vertexs, int i) {
        vertexs.add(i);
        if( map.containsKey(i)){
            int destination = map.get(i);
//            System.out.println(i + " " + destination);
            if( destination != 0 && !vertexs.contains(destination)) {
                goRoot(map, vertexs, destination);
            }
        }

    }
}
