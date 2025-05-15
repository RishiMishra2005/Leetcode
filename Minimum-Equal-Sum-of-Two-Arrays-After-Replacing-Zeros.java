class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += (long) n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        long zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += (long) n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        long minSum1 = sum1+zeroCount1;
        long minSum2 = sum2+zeroCount2;

        if (minSum1<minSum2 && zeroCount1 == 0) {
            return -1;
        }

        if (minSum1>minSum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}