class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double area = 0.0;
        double li = Double.MAX_VALUE;
        double he = -Double.MAX_VALUE;
        
        for (int[] s : squares) {
            int y = s[1], l = s[2];
            area += (double) l * l;
            li = Math.min(li, y);
            he = Math.max(he, y + l);
        }
        
        double target = area / 2.0;
        for (int i = 0; i < 100; i++) {
            double mid = (li + he) / 2.0;
            double areaBelow = 0.0;
            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];
                double top = y + l;
                if (mid <= y) {
                    areaBelow += 0;
                } else if (mid >= top) {
                    areaBelow += l * l;
                } else {
                    areaBelow += (mid - y) * l;
                }
            }
            if (areaBelow < target) {
                li = mid;
            } else {
                he = mid;
            }
        }
        
        return he;
    }
}
