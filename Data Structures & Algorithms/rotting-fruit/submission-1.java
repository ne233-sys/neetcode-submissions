class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] curr;
        int count = 0, m = 0;

        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == 2) queue.add(new int[]{i, j, 0});
            if(grid[i][j] == 1) count++;
        }

        if(count == 0) return 0;

        while(!queue.isEmpty()){
            curr = queue.remove();
            int row = curr[0], col = curr[1];
            if(curr[2] > m) m = curr[2];

            if(row > 0 && grid[row-1][col] == 1){
                grid[row-1][col] = 2;
                queue.add(new int[]{row-1, col, curr[2]+1});
                count--;
            }

            if(row < grid.length - 1 && grid[row+1][col] == 1){
                grid[row+1][col] = 2;
                queue.add(new int[]{row+1, col, curr[2]+1});
                count--;
            }

            if(col > 0 && grid[row][col-1] == 1){
                grid[row][col-1] = 2;
                queue.add(new int[]{row, col-1, curr[2]+1});
                count--;
            }

            if(col < grid[0].length - 1 && grid[row][col+1] == 1){
                grid[row][col+1] = 2;
                queue.add(new int[]{row, col+1, curr[2]+1});
                count--;
            }
        }

        if(count != 0) return -1;
        else return m;
    }
}
