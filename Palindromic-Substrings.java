class Solution {
    int res = 0;
    public int countSubstrings(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            i = getCount(s, i);
        }
        return res;
    }

    public int getCount(String s, int index) {
        int left = index - 1, right = index, n = s.length();
        while (right < n - 1 && s.charAt(right) == s.charAt(right + 1)) {
            right++;
        }
        int countOfSameChar = right - left;
        if(countOfSameChar >= 1){
            res += (countOfSameChar*(countOfSameChar+1))/2 ;
        }
        int nextIndex = right++;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            res++;
        }
        return nextIndex;
    }
}