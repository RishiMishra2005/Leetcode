class Solution {
    public long[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };

    public long[] fact() {
        return factorial;
    }

    static public long create(int num, int n) {
        long res = num, pro = (long) (Math.pow(10, n - 1));
        n /= 2;
        while (num > 0 && n > 0) {
            res += (num % 10) * pro;
            pro /= 10;
            num /= 10;
            n--;
        }
        return res;
    }

    static public long countGoodIntegers(int n, int k) {
        Solution xx = new Solution();
        xx.fact();
        long ans = 0;
        HashSet<String> mh = new HashSet<>();
        int m = (n + 1) / 2;
        long till = (int) (Math.pow(10, m));
        for (long i = 0; i < till; i++) {
            long x = create((int) i, n);
            if (x % k == 0 && palindrome(x, mh)) {
                ans += permutation(x, xx.fact());
            }
        }
        return ans;
    }

    static long permutation(long n, long[] fact) {
        int[] arr = new int[11];
        char[] sarr = Long.toString(n).toCharArray();
        for (char c : sarr) {
            arr[(int) (c - 48)]++;
        }
        long totalFreq = sarr.length;
        totalFreq = fact[(int) (totalFreq)];
        long res = 1;
        for (int i = 0; i < 11; i++) {
            res *= (fact[arr[i]]);
        }
        totalFreq /= res;
        if (arr[0] == 0) {
            return totalFreq;
        }
        res = 1;
        arr[0]--;
        long total = fact[sarr.length - 1];
        for (int i = 0; i < 11; i++) {
            res *= (fact[arr[i]]);
        }
        total /= res;
        return totalFreq - total;
    }

    static boolean palindrome(long num, HashSet<String> mh) {
        char[] sarr = Long.toString(num).toCharArray();
        int i = 0, j = sarr.length - 1;
        while (i < j) {
            if (sarr[i] != sarr[j]) {
                return false;
            }
            i++;
            j--;
        }

        Arrays.sort(sarr);
        String sortedStr = new String(sarr);

        if (mh.contains(sortedStr)) {
            return false;
        }

        mh.add(sortedStr);
        return true;
    }
}