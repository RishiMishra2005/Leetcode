public class Solution {
    public static int coinChange(int[] coins, int target) {
        if (target == 0)
            return 0;

        int n = coins.length;
        if (n == 1)
            return target % coins[0] == 0 ? target / coins[0] : -1;

        Arrays.sort(coins);

        int minCoin = coins[0];
        if (target == minCoin)
            return 1;
        int idx = 1, gcdVal = minCoin;
        while (idx < n && target >= coins[idx]) {
            if (target == coins[idx])
                return 1;
            gcdVal = gcd(coins[idx], gcdVal);
            coins[idx] -= minCoin;
            idx++;
        }
        if (target % gcdVal != 0)
            return -1;

        int minVal = (target - 1) / (coins[idx - 1] + minCoin) + 1;
        int maxVal = target / minCoin;
        for (int i = minVal; i <= maxVal; i++) {
            if (findCombination(coins, 1, idx - 1, target - i * minCoin, i))
                return i;
        }
        return -1;
    }

    private static boolean findCombination(int[] coins, int left, int right, int target, int maxCoins) {
        if (target == 0)
            return true;
        if (target < coins[left] || target / coins[right] > maxCoins)
            return false;
        if (target % coins[right] == 0)
            return true;
        if (left == right)
            return false;
        for (int k = target / coins[right] + 1; k-- > 0; ) {
            if (findCombination(coins, left, right - 1, target - k * coins[right], maxCoins - k))
                return true;
        }
        return false;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}