public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int[] dp = new int[2 * totalSum + 1];

        // Initialize the first row of the DP table
        dp[nums[0] + totalSum] = 1; // Adding nums[0]
        dp[-nums[0] + totalSum] += 1; // Subtracting nums[0]

        // Fill the DP table
        for (int index = 1; index < nums.length; index++) {
            int[] next = new int[2 * totalSum + 1];
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[sum + totalSum] > 0) {
                    next[sum + nums[index] + totalSum] += dp[sum + totalSum];
                    next[sum - nums[index] + totalSum] += dp[sum + totalSum];
                }
            }
            dp = next;
        }

        // Return the result if the target is within the valid range
        return Math.abs(target) > totalSum ? 0 : dp[target + totalSum];
    }
}