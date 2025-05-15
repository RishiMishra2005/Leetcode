class Solution {
    public int lengthAfterTransformations(String s, int t) {
    	int MOD = (int)1e9 + 7, ans = 0;
        long[] count = new long[26];
        for (int c : s.toCharArray())
        	count[c - 'a']++;
        for (; t >= 26; t -= 26) {
        	long z = count[25];
        	for (int i = 25; i > 0; i--)
        		count[i] = (count[i] + count[i - 1]) % MOD;
        	count[0] = (count[0] + z) % MOD;
        	count[1] = (count[1] + z) % MOD;
        }
        for (int i = 0; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        for (int i = 26 - t; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        return ans;
    }
}