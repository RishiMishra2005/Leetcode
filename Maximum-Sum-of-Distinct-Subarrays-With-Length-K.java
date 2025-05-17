class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        long curSum = 0;
        
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            
            if (r - l + 1 > k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                if (count.get(nums[l]) == 0) {
                    count.remove(nums[l]);
                }
                curSum -= nums[l];
                l++;
            }
            
            if (count.size() == r - l + 1 && r - l + 1 == k) {
                res = Math.max(res, curSum);
            }
        }
        
        return res;
    }
}