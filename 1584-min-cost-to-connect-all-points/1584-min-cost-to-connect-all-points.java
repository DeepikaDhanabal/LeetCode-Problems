class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        // Initially, all distances are infinity
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Start from point 0
        distance[0] = 0;

        int total = 0;

        for (int count = 0; count < n; count++) {

            // Find the unvisited point
            // with minimum distance
            int current = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (current == -1 || distance[i] < distance[current])) {

                    current = i;
                }
            }

            // Visit this point
            visited[current] = true;

            // Add its cost
            total += distance[current];

            // Update distance of other points
            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    int cost = Math.abs(points[current][0] - points[i][0])
                             + Math.abs(points[current][1] - points[i][1]);

                    if (cost < distance[i]) {
                        distance[i] = cost;
                    }
                }
            }
        }

        return total;
    }
}