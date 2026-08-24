class Solution {
    private char[][] board, copy;
    public void solve(char[][] board) {
        if(board.length < 3 || board[0].length < 3) return;

        this.board = board;
        copy = new char[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) for(int j = 0; j < board[0].length; j++) copy[i][j] = board[i][j];

        for(int i = 1; i < board.length - 1; i++) for(int j = 1; j < board[0].length - 1; j++) board[i][j] = 'X';

        for(int i = 0; i < board[0].length; i++) if(board[0][i] == 'O') dfs(0, i);
        for(int i = 0; i < board[0].length; i++) if(board[board.length - 1][i] == 'O') dfs(board.length - 1, i);
        for(int i = 0; i < board.length; i++) if(board[i][0] == 'O') dfs(i, 0);
        for(int i = 0; i < board.length; i++) if(board[i][board[0].length - 1] == 'O') dfs(i, board[0].length - 1);
    }

    private void dfs(int row, int col){
        copy[row][col] = 'X';

        if(row > 0 && copy[row-1][col] != 'X'){
            board[row-1][col] = 'O';
            dfs(row-1, col);
        }

        if(row < board.length - 1 && copy[row+1][col] != 'X'){
            board[row+1][col] = 'O';
            dfs(row+1, col);
        }

        if(col > 0 && copy[row][col-1] != 'X'){
            board[row][col-1] = 'O';
            dfs(row, col-1);
        } 

        if(col < board[0].length - 1 && copy[row][col+1] != 'X'){
            board[row][col+1] = 'O';
            dfs(row, col+1);
        } 
    }
}
