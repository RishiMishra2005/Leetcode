class Solution {
    public String smallestNumber(String pattern) {
        int top = 0, s[] = new int[10], n = pattern.length();
        StringBuilder res = new StringBuilder();
        s[0] = 1;
        for (int i = 0; i < n; i++){
            if (pattern.charAt(i) == 'I'){
                while (top >= 0) res.append(s[top--]);
            }
            s[++top] = i + 2;
        }
        while (top >= 0) res.append(s[top--]);
        return res.toString();
    }
}