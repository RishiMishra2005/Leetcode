class Solution {
    public boolean canBeValid(String parentheses, String status) {
        int length = parentheses.length();
        if (length % 2 != 0) return false;
        int minBalance = 0, maxBalance = 0;
        for (int i = 0; i < length; i++) {
            boolean isOpening = parentheses.charAt(i) == '(';
            boolean isUnlocked = status.charAt(i) == '0';
            minBalance += (!isOpening || isUnlocked) ? -1 : 1;
            maxBalance += (isOpening || isUnlocked) ? 1 : -1;
            if (maxBalance < 0) return false;
            minBalance = Math.max(minBalance, 0);
        }
        return minBalance == 0;
    }
}