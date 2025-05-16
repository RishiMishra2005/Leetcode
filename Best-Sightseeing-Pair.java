class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxLeftScore = values[0];

        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            maxScore = Math.max(maxScore, maxLeftScore + currentRightScore);

            int currentLeftScore = values[i] + i;
            maxLeftScore = Math.max(maxLeftScore, currentLeftScore);
        }

        return maxScore;
    }
}