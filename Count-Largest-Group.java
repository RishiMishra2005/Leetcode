class Solution {
    int[][] ref = { {1}, new int[10], new int[19], new int[28] };
    
    public int countLargestGroup(int n) {
        int[] digits = {1,0,0,0}, counts = new int[37];
        int power = 0, psum = 0;
        for (int num = Math.min(n, 9999); num > 0; num /= 10)
            psum += digits[power++] += num % 10;
        for (int d = 0; d < power; d++) {
            int digit = digits[d], prevSize = ref[d].length;
            int currSize = d > 2 || ref[d + 1][ref[d + 1].length - 1] > 0 ? 0 : ref[d + 1].length;
            int limit = Math.max(d * 9 + digit, currSize);
            psum -= digit;
            for (int i = 0, val = 0; i < limit; i++) {
                val += (i < prevSize ? ref[d][i] : 0)
                     - (i >= digit && i - digit < prevSize ? ref[d][i - digit] : 0);
                counts[psum + i] += val;
                if (currSize > 0)
                    ref[d + 1][i] = (i > 0 && i - 1 < currSize ? ref[d + 1][i - 1] : 0)
                            + (i < prevSize ? ref[d][i] : 0)
                            - (i >= 10 && i - 10 < prevSize ? ref[d][i - 10] : 0);
            }
        }
        counts[0] = 0;
        int count = 0, max = 0;
        for (int x : counts)
            if (x > max) {
                max = x;
                count = 1;
            } else if (x == max)
                count++;
        return count;
    }
    }