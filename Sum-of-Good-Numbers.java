class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isGood = true;
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                isGood = false;
            }
            if (i + k < nums.length && nums[i] <= nums[i + k]) {
                isGood = false;
            }
            if (isGood) {
                sum += nums[i];
            }
        }
        return sum;
    }
}