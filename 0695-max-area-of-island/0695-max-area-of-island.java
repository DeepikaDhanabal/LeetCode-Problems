class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {

        // Boundary check
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }

        // Mark visited
        grid[i][j] = 0;

        int area = 1;

        // Up
        area += dfs(grid, i - 1, j);

        // Down
        area += dfs(grid, i + 1, j);

        // Left
        area += dfs(grid, i, j - 1);

        // Right
        area += dfs(grid, i, j + 1);

        return area;
    }
}