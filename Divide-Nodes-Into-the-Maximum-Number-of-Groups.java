class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        n++;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int edg[] : edges)
        {
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }

        if(!isBipartite(adj, n))
            return -1;

        int degreeBFS[] = new int[n];
        for(int i = 1; i < n; i++)
            degreeBFS[i] = bfsdegree(adj, i);

        int vis[] = new int[n];
        int grp = 0;
        for(int i = 1; i < n; i++)
            if(vis[i] == 0)
                grp += dfs(adj, vis, degreeBFS, i);

        return grp;
    }

    public int dfs(List<List<Integer>> adj,int vis[], int deg[], int vertex) {
        vis[vertex] = 1;
        int componentMax = deg[vertex];
        for(int ver : adj.get(vertex))
            if(vis[ver] == 0)
                componentMax = Math.max(componentMax, dfs(adj, vis, deg, ver));
        return componentMax;
    }

    public int bfsdegree(List<List<Integer>> adj, int vertex) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{vertex, 1});
        int vis[] = new int[adj.size()];
        vis[vertex] = 1;
        int ele[] = new int[2];
        while(!q.isEmpty())
        {
            ele = q.poll();
            for(int ver : adj.get(ele[0]))
                if(vis[ver] == 0)
                {
                    vis[ver] = 1;
                    q.add(new int[]{ver, ele[1] + 1});
                }
        }
        return ele[1];
    }

    public boolean isBipartite(List<List<Integer>> adj, int n) {
        int color[] = new int[n];
        for(int i = 0; i < n; i++)
            if(color[i] == 0 && !bfs(adj, color, i))
                return false;
        return true;
    }

    public boolean bfs(List<List<Integer>> adj, int color[], int vertex) {
        color[vertex] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while(!q.isEmpty())
        {
            int ele = q.poll();
            int col = color[ele] == 1 ? 2 : 1;
            for(int ver : adj.get(ele))
                if(color[ver] == 0)
                {
                    color[ver] = col;
                    q.add(ver);
                }
                else if(color[ver] != col)
                    return false;
        }
        return true;
    }
}