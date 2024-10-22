package codelearn.leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "AAB";
        System.out.println(new WordSearch().exist(board, word));
    }
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char firstChar = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == firstChar && checkExistWord(i, j, board, word, 0)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean checkExistWord(int i, int j, char[][] board, String word, int indexW) {
        if (indexW + 1 == word.length())
            return true;
        boolean result = false;
        char next = word.charAt(indexW + 1);
        visited[i][j] = true;
        if (i + 1 < board.length && board[i + 1][j] == next && !visited[i + 1][j]) {
            result = checkExistWord(i + 1, j, board, word, indexW + 1);
        }
        if (i - 1 >= 0 && board[i - 1][j] == next && !visited[i - 1][j]) {
            result = result || checkExistWord(i - 1, j, board, word, indexW + 1);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == next && !visited[i][j + 1]) {
            result = result || checkExistWord(i, j + 1, board, word, indexW + 1);
        }
        if (j - 1 >= 0 && board[i][j - 1] == next && !visited[i][j - 1]) {
            result = result || checkExistWord(i, j - 1, board, word, indexW + 1);
        }
        visited[i][j] = false;

        return result;
    }
}
