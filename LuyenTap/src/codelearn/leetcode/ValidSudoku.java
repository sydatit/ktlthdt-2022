package codelearn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {

        int n = board.length;
        for (int i = 0; i < n; i++) {
            Set<Character> setRow = new HashSet<>();
            Set<Character> setCol = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (setRow.contains(board[i][j]))
                        return false;
                    else setRow.add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    if (setCol.contains(board[j][i]))
                        return false;
                    else setCol.add(board[j][i]);
                }
            }
        }
        System.out.println("ok");
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                System.out.println(i + " " + j + " ");
                if (!check(i, j, board))
                    return false;
            }
        }
        return true;
    }

    private static boolean check(int i, int j, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                System.out.println(k + " - " + l);
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j]))
                        return false;
                    else set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
