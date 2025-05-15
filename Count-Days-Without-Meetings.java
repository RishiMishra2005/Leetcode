
import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int unvisited = 0, temp = 1;
        
        for (int[] m : meetings) {
            unvisited += Math.max(0, m[0] - temp);
            temp = Math.max(temp, m[1] + 1);
            if (temp > days) {
                break;
            }
        }
        
        return unvisited + Math.max(0, days - temp + 1);
    }
}