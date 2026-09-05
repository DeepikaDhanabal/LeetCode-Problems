class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] state = new int[n];

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (dfs(i, graph, state)) {
                answer.add(i);
            }
        }

        return answer;
    }

    public boolean dfs(int node, int[][] graph, int[] state) {

        // Already visiting → cycle
        if (state[node] == 1) {
            return false;
        }

        // Already checked and safe
        if (state[node] == 2) {
            return true;
        }

        // Mark as visiting
        state[node] = 1;

        for (int next : graph[node]) {

            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // All neighbours are safe
        state[node] = 2;

        return true;
    }
}