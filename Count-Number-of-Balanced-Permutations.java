class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_SIZE = 41;
    private static final long[] factorials = new long[MAX_SIZE];
    private static final long[] inverseFactorials = new long[MAX_SIZE];
    
    static {
        initializeFactorials();
        initializeInverseFactorials();
    }
    
    private static void initializeFactorials() {
        factorials[0] = 1;
        for (int i = 1; i < MAX_SIZE; i++) {
            factorials[i] = factorials[i - 1] * i % MOD;
        }
    }
    
    private static void initializeInverseFactorials() {
        inverseFactorials[MAX_SIZE - 1] = modularPow(factorials[MAX_SIZE - 1], MOD - 2);
        for (int i = MAX_SIZE - 1; i > 0; i--) {
            inverseFactorials[i - 1] = inverseFactorials[i] * i % MOD;
        }
    }
    
    public int countBalancedPermutations(String num) {
        int[] digitCounts = calculateDigitCounts(num);
        int totalSum = calculateTotalSum(num);
        
        if (totalSum % 2 != 0) {
            return 0;
        }
        
        for (int i = 1; i < 10; i++) {
            digitCounts[i] += digitCounts[i - 1];
        }
        
        int length = num.length();
        int halfLength = length / 2;
        
        int[][][] memo = initializeMemoArray(halfLength, totalSum);
        
        return (int) (factorials[halfLength] * 
                     factorials[length - halfLength] % MOD * 
                     recursiveBalance(9, halfLength, totalSum / 2, digitCounts, memo) % MOD);
    }
    
    private int[] calculateDigitCounts(String num) {
        int[] counts = new int[10];
        for (char c : num.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
    
    private int calculateTotalSum(String num) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
    
    private int[][][] initializeMemoArray(int halfLength, int totalSum) {
        int[][][] memo = new int[10][halfLength + 1][totalSum / 2 + 1];
        for (int[][] matrix : memo) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return memo;
    }
    
    private int recursiveBalance(int digit, int remainingLeft, int remainingSum, 
                               int[] digitCounts, int[][][] memo) {
        if (digit < 0) {
            return remainingSum == 0 ? 1 : 0;
        }
        
        if (memo[digit][remainingLeft][remainingSum] != -1) {
            return memo[digit][remainingLeft][remainingSum];
        }
        
        long result = 0;
        int currentCount = digitCounts[digit] - (digit > 0 ? digitCounts[digit - 1] : 0);
        int remainingRight = digitCounts[digit] - remainingLeft;
        
        for (int k = Math.max(currentCount - remainingRight, 0); 
             k <= Math.min(currentCount, remainingLeft) && k * digit <= remainingSum; 
             k++) {
            long subResult = recursiveBalance(digit - 1, 
                                           remainingLeft - k, 
                                           remainingSum - k * digit, 
                                           digitCounts, 
                                           memo);
            result = (result + subResult * inverseFactorials[k] % MOD * 
                     inverseFactorials[currentCount - k]) % MOD;
        }
        
        memo[digit][remainingLeft][remainingSum] = (int) result;
        return (int) result;
    }
    
    private static long modularPow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exponent /= 2;
        }
        return result;
    }
}