class Solution {
    private int[][] g;
    public int maxAreaOfIsland(int[][] grid) {
        g = grid;
        int max = 0;
        for(int i = 0; i < g.length; i++) for(int j = 0; j < g[0].length; j++) if(g[i][j] == 1){
            int temp = iflag(i, j);
            if (temp > max) max = temp;
        }
        return max;
    }

    private int iflag(int i, int j){
        if(g[i][j] != 1) return 0;
        else g[i][j] = 2;

        int n = 1;

        if(i > 0 && g[i-1][j] == 1) n += iflag(i-1, j);
        if(i < g.length-1 && g[i+1][j] == 1) n += iflag(i+1, j);
        if(j > 0 && g[i][j-1] == 1) n += iflag(i, j-1);
        if(j < g[0].length-1 && g[i][j+1] == 1) n += iflag(i, j+1);

        return n;
    }
}
