class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = -1, min = -1, max = -1, n = nums.length;
        long count = 0l;
        for (int i = 0; i < n; i++) 
            if (nums[i] < minK || nums[i] > maxK) 
                left = min = max = i;
            else {
                min = nums[i] == minK ? i : min;
                max = nums[i] == maxK ? i : max;
                count += (min < max ? min : max) - left;
            } 
        return count;
    }
}