package codelearn.io;

import java.util.ArrayList;

public class GasStation {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int startI = 0;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[n];
        for( int i = 0; i < n; i++){
            if(gas[i] >= cost[i]) check[i] = true;
        }
        for (int i = 0; i < n; i++) {
            if( i == 0){
                if( !check[n-1] && check[i]) list.add(i);
            }else {
                if( check[i] && !check[i-1]) list.add(i);
            }
        }

        return 0;
    }
    public boolean BFS(int present, int remainGas, int length, int start, int[] gas, int[] cost ){
        if( present == start) return true;
        if( gas[present] + remainGas < cost[present]) return false;

        return true;
    }
}
