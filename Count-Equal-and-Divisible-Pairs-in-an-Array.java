class Solution {
    public int countPairs(int[] nums, int k) {
        return helper(nums, k, 0);
    }

    private static int helper(int[] nums, int k, int i) {
        if (i >= nums.length) {
            return 0;
        }
        int count = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j] && (i * j) % k == 0) {
                count++;
            }
        }
        return count + helper(nums, k, i + 1);
    }
}