class Solution {

    int[] parent;

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        parent[i] = find(parent[i]);
        return parent[i];
    }

    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length + 1];

        // Initially, every node is its own parent
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            // Already connected → redundant edge
            if (rootU == rootV) {
                return new int[]{u, v};
            }

            // Union
            parent[rootU] = rootV;
        }

        return new int[]{};
    }
}