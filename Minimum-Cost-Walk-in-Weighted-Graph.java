class Solution {

    public class UnionFind{
        public int[] p;
        public int[] val; // & of all
        public int[] d;

        UnionFind(int n){
            p = new int[n];
            val = new int[n];
            d = new int[n];
            Arrays.fill(p, -1);
            Arrays.fill(val, 0xFFFFFFF);
            Arrays.fill(d, 0);
        }

        public  int findp(int u){
            while(p[u] != -1) u = p[u];
            return u;
        }

        public void union(int u, int v, int wt){
            u = findp(u);
            v = findp(v);

            if(u == v){
                val[u] &= wt;
                return;
            }

            if(d[u] > d[v]){
                p[v] = u;
                val[u] &= wt;
                val[u] &= val[v];   
            }
            else if(d[v] > d[u]){
                p[u] = v;
                val[v] &= wt;
                val[v] &= val[u];
            }
            else{
                p[v] = u;
                val[u] &= wt;
                val[u] &= val[v];
                d[u]++;
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);

        for(int[] e : edges)uf.union(e[0], e[1], e[2]);


        int[] ans = new int[query.length];
        int id = 0;

        for(int[] q : query){
            int p1 = uf.findp(q[0]);
            int p2 = uf.findp(q[1]);
            if(p1 == p2){
                ans[id++] = uf.val[p1];
            }
            else ans[id++] = -1;
        }

        return ans;
    }
}