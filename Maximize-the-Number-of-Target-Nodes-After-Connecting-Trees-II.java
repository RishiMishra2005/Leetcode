class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        final int[] t1 = target(edges1);
        final int plus = max(target(edges2));
        for (int i = 0; i < t1.length; i++) {
            t1[i] += plus;
        }
        return t1;
    }

    static final int max(int[] arr) {
        int r = 0;
        for (int a : arr) {
            r = Math.max(r, a);
        }
        return r;
    }

    static int[] target(int[][] edges) {
        final int n = edges.length + 1;
        final int[] degree = new int[n];
        final int[] parents = new int[n];
        final int[] balance = new int[n];
        Arrays.fill(balance, 1);
        final int[] q = new int[n];
        for (int[] e : edges) {
            final int start = e[0];
            final int end = e[1];
            degree[start]++;
            degree[end]++;
            parents[start] ^= end;
            parents[end] ^= start;
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q[len++] = i;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            final int node = q[i];
            final int parent = parents[node];
            parents[parent] ^= node;
            balance[parent] -= balance[node];
            if (--degree[parent] == 1) {
                q[len++] = parent;
            }
        }
        final int root = q[n - 1];
        balance[root] = (n + balance[root]) / 2;
        for (int i = n - 2; i >= 0; i--) {
            final int node = q[i];
            balance[node] = n - balance[parents[node]];
        }
        return balance;
    }
}