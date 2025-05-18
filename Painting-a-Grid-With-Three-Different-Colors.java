class Solution {
    static int mod =  1_000_000_007;
    static long[][][] matrixs = {
            { { 2 } },
            { { 3 } },
            { { 3, 2 }, { 2, 2 } },
            {
                { 3, 2, 1, 2 },
                { 2, 2, 1, 2 },
                { 1, 1, 2, 1 },
                { 2, 2, 1, 2 },
            },
            {
                { 3, 2, 2, 1, 0, 1, 2, 2 },
                { 2, 2, 2, 1, 1, 1, 1, 1 },
                { 2, 2, 2, 1, 0, 1, 2, 2 },
                { 1, 1, 1, 2, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 2, 1, 1 },
                { 2, 1, 2, 1, 0, 1, 2, 1 },
                { 2, 1, 2, 1, 1, 1, 1, 2 },
            },
        };

    public int colorTheGrid(int m, int n) {

        int len = m == 1 ? 1 : (int) (Math.pow(2, m - 2));

        long[][] dp = new long[len][1];
        for (long[] row : dp) {
            row[0] = m == 1 ? 3 : 6;
        }

        long[][] matrix = matrixs[m - 1];
        dp = multiply(matrixPower(matrix, n - 1, mod), dp, mod);

        long result = 0l;
        for (long[] row : dp)
            result = (result + row[0]) % mod;
        
        return (int)result;
    }

    private long[][] multiply(long[][] a, long[][] b, long mod) {

        int m = a.length, n = b[0].length, p = b.length;
        long[][] c = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    c[i][j] += a[i][k] * b[k][j] % mod;
                    c[i][j] %= mod;
                }
            }
        }
        return c;
    }

    private long[][] matrixPower(long[][] matrix, long n, long mod) {
        long[][] result = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) 
            result[i][i] = 1;
   
        while (n != 0) {
            if ((n & 1) != 0) 
                result = multiply(result, matrix, mod);
            
            matrix = multiply(matrix, matrix, mod);
            n >>= 1;
        }
        return result;        
    }
}