class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1, n = s.length();
        for (; i < n && s.charAt(i) == ' '; i++) 
            ;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) { 
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        long num = 0;
        for (; i < n && Character.isDigit(s.charAt(i)) && num <= Integer.MAX_VALUE; i++) { 
            num = num * 10 + s.charAt(i) - '0';
        }
        num = Math.max(sign * num, Integer.MIN_VALUE);
        num = Math.min(num, Integer.MAX_VALUE);
        return (int) num;
    }
}