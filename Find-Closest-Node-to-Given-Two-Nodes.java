class Solution {
    public int[] dfs(int[] edges, int start) {
        int[] dist = new int[edges.length];
        Arrays.fill(dist, -1);
        int d = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }
        return dist;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = dfs(edges, node1);
        int[] dist2 = dfs(edges, node2);
        int result = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }
}