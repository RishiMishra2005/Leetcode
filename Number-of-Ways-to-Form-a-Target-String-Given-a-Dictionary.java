class Solution {

    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        final int MOD = 1_000_000_007;

        //Step 1: Calculate frequency of each character at every index in "words".
        int[][] charFrequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        //Step 2: Initialize two DP arrays: prev and curr.
        long[] prevCount = new long[targetLength + 1];
        long[] currCount = new long[targetLength + 1];

        //Base case: There is one way to form an empty target string.
        prevCount[0] = 1;

        //Step 3: Fill the DP arrays.
        for (int currWord = 1; currWord <= wordLength; currWord++) {
            // Copy the previous row into the current row for DP.
            System.arraycopy(prevCount, 0, currCount, 0, currCount.length);
            for (int currTarget = 1; currTarget <= targetLength; currTarget++) {
                // If characters match, add the number of ways.
                int curPos = target.charAt(currTarget - 1) - 'a';
                currCount[currTarget] +=
                    (1L *
                        charFrequency[currWord - 1][curPos] *
                        prevCount[currTarget - 1]) %
                    MOD;
                currCount[currTarget] %= MOD;
            }
            // Move current row to previous row for the next iteration.
            System.arraycopy(currCount, 0, prevCount, 0, prevCount.length);
        }

        //Step 4: The result is in prev[targetLength].
        return (int) prevCount[targetLength];
    }
}