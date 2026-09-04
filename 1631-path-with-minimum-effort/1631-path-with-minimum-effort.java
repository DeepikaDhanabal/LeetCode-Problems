import java.util.*;

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // effort, row, col
        pq.offer(new int[]{0, 0, 0});

        effort[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currEffort = current[0];
            int r = current[1];
            int c = current[2];

            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) {

                    int difference = Math.abs(
                        heights[r][c] - heights[nr][nc]
                    );

                    int newEffort = Math.max(
                        currEffort,
                        difference
                    );

                    if (newEffort < effort[nr][nc]) {

                        effort[nr][nc] = newEffort;

                        pq.offer(
                            new int[]{newEffort, nr, nc}
                        );
                    }
                }
            }
        }

        return 0;
    }
}