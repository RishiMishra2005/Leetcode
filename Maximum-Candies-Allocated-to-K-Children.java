class Solution {

    public boolean checkvalid(int[] candie, int val, long m) {
        long count = 0;
        for (int k = 0; k < candie.length; k++) {
            count = count + candie[k] / val;
        }
        return count >= m;
    }

    public int maximumCandies(int[] candies, long k) {

        long sum = 0;
        int min = 1;
        for (int i = 0; i < candies.length; i++) {
            sum = sum + candies[i];
        }
        if (sum < k) {
            return 0;
        }
        int max = (int) (sum / k);
        while (min <= max) {
            int mid = (min + max) / 2;
            if (checkvalid(candies, mid, k)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}