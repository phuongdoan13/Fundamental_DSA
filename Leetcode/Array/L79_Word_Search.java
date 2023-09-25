package Leetcode.Array;

public class L79_Word_Search {
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (trace(board, word, 0, r, c))
                    return true;
            }
        }
        return false;
    }

    boolean trace(char[][] board, String word, int currCharIdx, int r, int c) {
        if (currCharIdx == word.length()) {
            return true;
        }
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] != word.charAt(currCharIdx)) {
            return false;
        }

        int[][] inc = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        char temp = board[r][c];
        for (int i = 0; i < 4; i++) {
            board[r][c] = '*';
            if (trace(board, word, currCharIdx + 1, r + inc[i][0], c + inc[i][1])) {
                return true;
            }

        }
        board[r][c] = temp;
        return false;
    }
}
