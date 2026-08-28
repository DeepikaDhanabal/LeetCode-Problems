class Solution {
    int rows, cols;
    int empty;
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int startRow = 0;                           //base condition
        int startCol = 0;
        empty = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    empty++;
                }
                if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                }
            }
        }
        return dfs(grid, startRow, startCol, empty); //dfs starts
    }
    private int dfs(int[][] grid, int r, int c, int empty) {
        if (r < 0 || r >= rows ||c < 0 || c >= cols || grid[r][c] == -1) {
            return 0;
        }
        if (grid[r][c] == 2) {         //destination
            return empty == 0 ? 1 : 0;
        }
        int temp = grid[r][c];
        if (grid[r][c] == 0) {
            empty--;
        }
        grid[r][c] = -1;
        int paths =
            dfs(grid, r + 1, c, empty) + //down
            dfs(grid, r - 1, c, empty) + //up
            dfs(grid, r, c + 1, empty) + //right
            dfs(grid, r, c - 1, empty); //left
        // BT 
        grid[r][c] = temp;
        return paths;
    }
}