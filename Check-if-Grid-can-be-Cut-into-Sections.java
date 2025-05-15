public class Solution {
    private static final int MASK = (1 << 30) - 1;

    public boolean checkValidCuts(int m, int[][] rectangles) {
        int n = rectangles.length;
        long[] start = new long[n];
        for (int i = 0; i < n; i++) {
            start[i] = ((long) rectangles[i][1] << 32) + rectangles[i][3];
        }
        Arrays.sort(start);
        if (validate(start)) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            start[i] = ((long) rectangles[i][0] << 32) + rectangles[i][2];
        }
        Arrays.sort(start);
        return validate(start);
    }

    private boolean validate(long[] arr) {
        int cut = 0;
        int n = arr.length;
        int max = (int) arr[0] & MASK;
        for (int i = 0; i < n; i++) {
            int start = (int) (arr[i] >> 32);
            if (start >= max && ++cut == 2) {
                return true;
            }
            max = Math.max(max, (int) (arr[i] & MASK));
        }
        return false;
    }
}