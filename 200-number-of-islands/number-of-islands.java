class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Iterate through every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Found new island - start traversal
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);  // Mark all connected land as visited
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        // Base case: out of bounds or already visited/water
        if (r < 0 || c < 0 || r >= grid.length || 
            c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        
        // Mark as visited by changing to water ('0')
        grid[r][c] = '0';
        
        // Visit all 4 directions (up, down, left, right)
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}