package codelearn.io;

import java.util.HashMap;
import java.util.Map;

public class SnakesLadders {
    public static void main(String[] args) {
        System.out.println((new SnakesLadders()).snakesAndLadders(
                new int[][]{
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}
                }
        ));
    }
    private int res;
    private boolean[][] mark;
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int count = 1;
        Map<Integer, Pair> pairMap = new HashMap<>();
        mark = new boolean[n][n];
        res = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if( i % 2 == 0){
                for (int j = n - 1; j >= 0 ; j--) {
                    pairMap.put(count++, new Pair(i, j));
                }
            }else {
                for (int j = 0; j < n ; j++) {
                    pairMap.put(count++, new Pair(i, j));
                }
            }
        }
        mark[n-1][0] = true;
        Try(1, 0, pairMap, board);
        return res;
    }

    private void Try(int curr, int count, Map<Integer, Pair> pairMap, int[][] board) {
        int n = board.length;
        if( curr == n*n){
            res = Math.min(res, count);
        }
        for (int i = curr + 1; i <= Math.min(curr + 6, n * n); i++) {
            Pair next = pairMap.get(i);
            if( !mark[next.getRow()][next.getColumn()]){
                // if square have a snake or ladder
                int snakeOrLadder = board[next.getRow()][next.getColumn()];
                if( snakeOrLadder != -1){
                    next = pairMap.get(snakeOrLadder);
                    mark[next.getRow()][next.getColumn()] = true;
                    Try(snakeOrLadder, count + 1, pairMap, board);
                    mark[next.getRow()][next.getColumn()] = false;
                }
                else{
                    mark[next.getRow()][next.getColumn()] = true;
                    Try(i, count + 1, pairMap, board);
                    mark[next.getRow()][next.getColumn()] = false;
                }

            }
        }
    }
}
class Pair{
    private int row;
    private int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
/*
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]


 */