class Solution {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Single pass: calculate moves from both left and right
        for (int i = 0; i < n; i++) {
            // Left pass
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;

            // Right pass
            int j = n - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }

        return answer;
    }
}