class Solution {
    long inf = Long.MAX_VALUE / 2;
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][n];
        long[] dist = new long[n];
        long[] count = new long[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], inf);
        }
        Arrays.fill(dist, inf);

        for (int[] r: roads) {
            int u = r[0], v = r[1], time = r[2];
            graph[u][v] = time;
            graph[v][u] = time;
        }

        graph[0][0] = 0;
        dist[0] = 0;
        count[0] = 1;
        for (int i =0; i <n; i++) {
            int cur = -1;
            for (int j = 0; j <n; j++) {
                if (!visited[j] && (cur == -1 || dist[j] < dist[cur])) {
                    cur = j;
                }
            }
            visited[cur] = true;
            for (int j = 0; j < n ;j++) {
                if (j == cur) {
                    continue;
                }

                long newDist = dist[cur] + graph[cur][j];
                if (dist[j] > newDist) {
                    dist[j] = newDist;
                    count[j] = count[cur];
                } else if (dist[j] == newDist) {
                    count[j] += count[cur];
                    count[j] %= mod;
                }
            }
        }
        return (int)count[n - 1];
    }
}