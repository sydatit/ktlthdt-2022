package codelearn.io;

import java.util.*;

public class MinimumTimeCollectApple {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if( map.containsKey(edges[i][0]) || edges[i][0] == 0 ){
                map.put(edges[i][1],edges[i][0] );
            }
            else{
                map.put(edges[i][0],edges[i][1] );
            }
        }
        Set<Integer> vertexs = new HashSet<>();
        for (int i = 0; i < hasApple.size(); i++) {
            if( hasApple.get(i).equals(true) && i != 0){
                goRoot(map, vertexs, i);
            }
        }
        if( vertexs.size() == 0)
            return 0;
        return vertexs.size()*2;
    }
    private void goRoot(Map<Integer, Integer> map, Set<Integer> vertexs, int i) {
        vertexs.add(i);
        if( map.containsKey(i)){
            int destination = map.get(i);
            if( destination != 0 && !vertexs.contains(destination)) {
                goRoot(map, vertexs, destination);
            }
        }

    }
}
