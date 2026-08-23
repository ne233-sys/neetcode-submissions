class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] curr;

        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) if(grid[i][j] == 0) queue.add(new int[]{i, j});

        while(!queue.isEmpty()){
            curr = queue.remove();
            int row = curr[0], col = curr[1];

            if(row > 0 && grid[row-1][col] > grid[row][col] + 1){
                grid[row-1][col] = grid[row][col] + 1;
                queue.add(new int[]{row-1, col});
            }

            if(row < grid.length - 1 && grid[row+1][col] > grid[row][col] + 1){
                grid[row+1][col] = grid[row][col] + 1;
                queue.add(new int[]{row+1, col});
            }

            if(col > 0 && grid[row][col-1] > grid[row][col] + 1){
                grid[row][col-1] = grid[row][col] + 1;
                queue.add(new int[]{row, col-1});
            }

            if(col < grid[0].length - 1 && grid[row][col+1] > grid[row][col] + 1){
                grid[row][col+1] = grid[row][col] + 1;
                queue.add(new int[]{row, col+1});
            }
        }
    }
}
