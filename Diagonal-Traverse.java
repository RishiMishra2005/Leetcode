class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int id = 0, r = 0, c = 0;

        for(int i = 0 ; r < m && c < n ; i++){

            if(i % 2 == 0){
                while(r >= 0 && c >= 0 && r < m && c <  n){
                    ans[id++] = mat[r][c];
                    r--;
                    c++;
                }

                if(c == n){
                    c--;
                    r += 2;
                }
                else{
                    r = r + 1;
                }
            }
            
            else{
                while(r >= 0 && c >= 0 && r < m && c <  n){
                    ans[id++] = mat[r][c];
                    r++;
                    c--;
                }

                if(r == m){
                    r--;
                    c += 2;
                }else{
                    c = c + 1;
                }
            }
        }

        return ans;
    }
}