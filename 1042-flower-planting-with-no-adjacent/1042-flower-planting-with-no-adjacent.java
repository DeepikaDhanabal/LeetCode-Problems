import java.util.*;

class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] graph = new ArrayList[n];

        // Create list for every garden
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Store neighbors
        for (int[] path : paths) {

            int a = path[0] - 1;
            int b = path[1] - 1;

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] flower = new int[n];

        // Give flower to each garden
        for (int i = 0; i < n; i++) {

            boolean[] used = new boolean[5];

            // Check neighbor flowers
            for (int neighbor : graph[i]) {

                if (flower[neighbor] != 0) {
                    used[flower[neighbor]] = true;
                }
            }

            // Choose available flower
            for (int f = 1; f <= 4; f++) {

                if (!used[f]) {
                    flower[i] = f;
                    break;
                }
            }
        }

        return flower;
    }
}