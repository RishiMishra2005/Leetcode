class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int maxVal = 2000;

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(isWater[r][c] == 1) isWater[r][c] = 0;
                else isWater[r][c] = 1;
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(isWater[r][c] != 0){
                    int top = maxVal;
                    int left = maxVal;
                    if(r - 1 >= 0) top = isWater[r - 1][c];
                    if(c - 1 >= 0) left = isWater[r][c - 1];
                    isWater[r][c] = Math.min(top, left) + 1;

                }
            }
        }

        for(int r = m - 1; r >= 0; r--){
            for(int c = n - 1; c >= 0; c--){
                if(isWater[r][c] != 0){
                    int bottom = maxVal;
                    int right = maxVal;
                    if(r + 1 < m) bottom = isWater[r + 1][c];
                    if(c + 1 < n) right = isWater[r][c + 1];
                    isWater[r][c] = Math.min(isWater[r][c], Math.min(bottom, right) + 1);
                }
            }
        }
        return isWater;
    }
}