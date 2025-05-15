import java.util.*;

class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            else if (neg == 0 && nums[i] > 0) return n - i;
            else if (nums[i] < 0) neg++;
            else if (nums[i] > 0) return Math.max(neg, n - i);
        }

        return Math.max(neg, 0);
    }
}