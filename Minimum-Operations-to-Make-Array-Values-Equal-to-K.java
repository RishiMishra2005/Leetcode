class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] has = new boolean[101];

        for (int num : nums) {
            has[num] = true;
        }
        int cnt = 0;
        for (int i = 0; i < has.length; i++) {
            if (!has[i]) continue;

            if (has[i] && i < k)
                return -1;
            else if (has[i] && i > k)
                cnt++;
        }
        return cnt;
    }
}