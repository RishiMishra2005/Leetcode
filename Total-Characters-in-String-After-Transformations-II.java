class Solution {
    public static final int MOD = (int)1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] cnt = getLetterCounts(s);
        int[][] transformMatrix = createTransformMatrix(nums);
        int[] transformedCnt = matrixExp(transformMatrix, cnt, t);
        long res = 0;
        for (int freq : transformedCnt) res += freq;
        return (int)(res % MOD);
    }

    private int[] getLetterCounts(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        return cnt;
    }

    private int[][] createTransformMatrix(List<Integer> nums) {
        int[][] A = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int lim = i + nums.get(i);
            for (int j = i + 1; j <= lim; j++) {
                A[j % 26][i] = 1;
            }
        }
        return A;
    }

    private int[] matrixVectorMult(int[][] A, int[] x) {
        int[] y = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                y[i] = (int)((y[i] + 1L * A[i][j] * x[j]) % MOD);
            }
        }
        return y;
    }

    private int[][] matrixSq(int[][] A) {
        int[][] C = new int[26][26];
        long[] acc = new long[26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(acc, 0L);
            for (int k = 0; k < 26; k++) {
                int aik = A[i][k];
                if (aik == 0) continue;

                int[] Ak = A[k];
                for (int j = 0; j < 26; j++) {
                    acc[j] += (long) aik * Ak[j];
                }
                if ((k & 3) == 3) {
                    for (int j = 0; j < 26; j++) {
                        acc[j] %= MOD;
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                C[i][j] = (int)(acc[j] % MOD);
            }
        }

        return C;
    }

    private int[] matrixExp(int[][] matrix, int[] vector, int exp) {
        int[][] sq = copy(matrix);
        while (exp > 0) {
            if ((exp & 1) == 1) vector = matrixVectorMult(sq, vector);
            sq = matrixSq(sq);
            exp >>= 1;
        }
        return vector;
    }

    private int[][] copy(int[][] matrix) {
        int[][] c = new int[26][26];
        for (int i = 0; i < 26; i++) {
            c[i] = matrix[i].clone();
        }
        return c;
    }
}