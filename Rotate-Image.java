class Solution {
    public void rotate(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = matrix.length - 1; j >= 0; j--) {
                l.add(matrix[j][i]);
            }
            list.add(l);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = list.get(i).get(j);
            }
        }
    }
}