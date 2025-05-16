class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            characterReplacement("", 1);
        }
    }
    public static int characterReplacement(String s, int k) {
        int[] mpp = new int[26];
        int left = 0;
        int maxi = 0;
        int n = s.length();
        int maxf = 0;

        for(int right = 0; right < n; ++right) {
            int ch = s.charAt(right) - 65;
            mpp[ch]++;
            maxf = Math.max(maxf, mpp[ch]);
            if(right - left + 1 - maxf > k) {
                mpp[s.charAt(left) - 65]--;
                left++;
            }
            else
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
    }