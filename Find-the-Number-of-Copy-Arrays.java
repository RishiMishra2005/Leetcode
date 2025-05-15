class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int minVal = bounds[0][0], maxVal = bounds[0][1];

        for (int i = 1; i < n; i++) {
            int diff = original[i] - original[i - 1];
            minVal = Math.max(minVal + diff, bounds[i][0]);
            maxVal = Math.min(maxVal + diff, bounds[i][1]);
            if (minVal > maxVal) return 0;
        }

        return maxVal - minVal + 1;
    }
}