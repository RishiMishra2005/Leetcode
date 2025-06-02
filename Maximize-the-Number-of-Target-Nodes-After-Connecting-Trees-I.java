class Solution {
    class Pair{
        int src;
        int nbr;
        Pair(int s,int n){
            this.src = s;
            this.nbr = n;
        }
    }
    private void fillGraph(ArrayList<Pair>[] graph,int[][] edges){
        int n = edges.length;
        for(int i = 0;i<=n;++i){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; ++i){
            int s = edges[i][0];
            int nb = edges[i][1];
            graph[s].add(new Pair(s,nb));
            graph[nb].add(new Pair(nb,s));
        }
    }
    private int dfs(ArrayList<Pair>[] graph,int s,boolean[] visited,int k){
        
        if(k == 0)return 1;
        visited[s] = true;
        int res = 1;
        for(Pair p:graph[s]){
            if(visited[p.nbr] == false){
                res += dfs(graph,p.nbr,visited,k-1);
            }
        }
        return res;
    }
    private int[] maxNode(ArrayList<Pair>[] graph,int k){
        
        int[] res = new int[graph.length];
        if(k == 0){
             Arrays.fill(res,1);
            return res;
        }
        if(k < 0 )return res;
        for(int i = 0;i<res.length;++i){
           res[i] =  dfs(graph,i,new boolean[res.length],k);
        }
        return res;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        ArrayList<Pair>[] graph1 = new ArrayList[n+1];
        ArrayList<Pair>[] graph2 = new ArrayList[m+1];

        fillGraph(graph1,edges1);
        fillGraph(graph2,edges2);

        int[] sec = maxNode(graph2,k-1);
        int max = 0;
        for(int i = 0;i<sec.length;++i){
            max = Math.max(sec[i],max);
        }

        int res[] = maxNode(graph1,k);
        for(int i = 0;i<res.length;++i){
            res[i] += max;
        }
        return res;
    }
}