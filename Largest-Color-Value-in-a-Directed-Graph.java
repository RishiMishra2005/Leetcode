class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        char[] cs = colors.toCharArray();
        int n = cs.length;
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n;i++) 
           graph[i] = new LinkedList<>();

        int[] indegree = new int[n];
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            indegree[v]++;
            graph[u].add(v);
        }
        
        int[][] count = new int[n][26]; 
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n;i++){
            if(indegree[i] == 0)
                que.offer(i);
        }
        
        int visited = 0;
        int result = 0;

        while (!que.isEmpty()){
            ++visited;
            int u = que.poll(), color = cs[u] -'a';
            result = Math.max(result, ++count[u][color]);

            for(int v: graph[u]){
                for(int i = 0; i < 26; ++i)
                    count[v][i] = Math.max(count[v][i], count[u][i]);
                
                if(--indegree[v] == 0)
                    que.offer(v);
                
            }
        }
        return visited == n? result : -1;
    }
}