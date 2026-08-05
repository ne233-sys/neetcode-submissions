class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] set = new HashSet[27];
        for(int i = 0; i < 27; i++) set[i] = new HashSet<>();

        for(int i = 0; i < 9; i++){ //columns
            for(int j = 0; j < 9; j++){ //rows
                char curr = board[i][j];

                if(curr != '.' && set[j].contains(curr)) return false; //sets from 0 to 8 (columns)
                else set[j].add(curr);

                if(curr != '.' && set[i + 9].contains(curr)) return false; //sets from 9 to 17 (rows)
                else set[i + 9].add(curr);

                if(curr != '.' && set[(i/3)*3 + j/3 + 18].contains(curr)) return false; //sets from 18 to 27 (squares)
                else set[(i/3)*3 + j/3 + 18].add(curr);
            }
        }

        return true;
    }
}
