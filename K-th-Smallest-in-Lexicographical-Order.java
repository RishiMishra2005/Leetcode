class Solution {
    public int findKthNumber(int n, int k) {
        k = k - 1;
        int curr = 1;
        while (k > 0) {
            int iteration = getCount(n, curr);
            if (iteration <= k) {
                curr++;
                k = k - iteration;
            } else {
                curr *= 10;
                k = k - 1;
            }
        }
        return curr;
    }

    public int getCount(int n, long tree1) {
        long tree2 = tree1 + 1;
        int iteration = 0;
        while (tree1 <= n) {
            iteration += Math.min(n + 1, tree2) - tree1;
            tree1 *= 10;
            tree2 *= 10;
        }

        return iteration;
    }
}