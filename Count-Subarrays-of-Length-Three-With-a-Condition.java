class Solution {
    public int countSubarrays(int[] nums) {
        int cnt = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (2 * (first + third) == second) {
                cnt++;
            }
        }
        return cnt;
    }
}