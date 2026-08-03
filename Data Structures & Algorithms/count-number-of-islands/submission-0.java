class Solution {
    private char[][] g;
    public int numIslands(char[][] grid) {
        g = grid;
        int n = 0;
        for(int i = 0; i < g.length; i++) for(int j = 0; j < g[0].length; j++) if(g[i][j] == '1'){
            n++;
            iflag(i, j);
        }
        return n;
    }

    private void iflag(int i, int j){
        if(g[i][j] != '1') return;
        else g[i][j] = '2';

        if(i > 0 && g[i-1][j] == '1') iflag(i-1, j);
        if(i < g.length-1 && g[i+1][j] == '1') iflag(i+1, j);
        if(j > 0 && g[i][j-1] == '1') iflag(i, j-1);
        if(j < g[0].length-1 && g[i][j+1] == '1') iflag(i, j+1);
    }
}
