class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++) for(int col = 0; col < board[0].length; col++) 
            if(board[row][col] == word.charAt(0) && rec(board, word, 0, row, col)) return true;
        return false;
    }

    private boolean rec(char[][] board, String word, int i, int row, int col) {
        if(i == word.length() - 1 && board[row][col] == word.charAt(i)) return true;
        if(board[row][col] != word.charAt(i)) return false;

        char temp = board[row][col];
        board[row][col] = '.';

        if(row > 0 && rec(board, word, i + 1, row - 1, col)) return true;
        if(row < board.length - 1 && rec(board, word, i + 1, row + 1, col)) return true;
        if(col > 0 && rec(board, word, i + 1, row, col - 1)) return true;
        if(col < board[0].length - 1 && rec(board, word, i + 1, row, col + 1)) return true;

        board[row][col] = temp;

        return false;
    }
}
