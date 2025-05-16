class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        int p[] = new int[n+1];
        
        for(int i =  1;i<n+1;i++) p[i] = i;
        
        int ans[] =  {0,0};
        
        for(int i = 0;i<n;i++){
            
            int p1 = p[edges[i][0]];
            int p2 = p[edges[i][1]];
           
            while(p1 != p[p1])
            p1 = p[p1];
            
             while(p2 != p[p2])
            p2 = p[p2];
           
            
            if(p1 == p2){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }
            else{
                p[p2] = p1;
            }
            
        }
        
        return ans;
        
    }
}