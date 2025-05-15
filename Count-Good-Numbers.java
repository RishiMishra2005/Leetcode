class Solution {
    final int M = 1_000_000_007;
    private long binpow(long a, long b) {
        a %= M;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % M;
            }
            a = a * a % M;
            b >>= 1;
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        long even_positions = (n + 1) / 2;
        long odd_positions = n / 2;
        long result = binpow(5, even_positions) * binpow(4, odd_positions) % M;
        return (int) result;
    }
}