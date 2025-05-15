class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] groupSize = new int[n];
        int[] groupEdges = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            groupSize[i] = 1;
        }

        for (int[] edge : edges) {
            int root1 = findRoot(parent, edge[0]);
            int root2 = findRoot(parent, edge[1]);
            if (root1 != root2) {
                parent[root1] = root2;
                groupSize[root2] += groupSize[root1];
                groupEdges[root2] += groupEdges[root1];
            }
            groupEdges[root2] += 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int size = groupSize[i], neededEdges = size * (size - 1) / 2;
            if (parent[i] == i && neededEdges == groupEdges[i]) {
                count += 1;
            }
        }
        return count;
    }

    private int findRoot(int[] parent, int cur) {
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }
}