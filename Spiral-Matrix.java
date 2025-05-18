class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top= 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        Integer[] arr = new Integer[matrix.length *  matrix[0].length];
        int runningIndex= 0;
        while(runningIndex!= arr.length){
            for(int n = left; n <= right && (runningIndex!= arr.length); n++){
                arr[runningIndex] = matrix[top][n];
                runningIndex++;
            }
            for(int n = top; n <bottom && (runningIndex!= arr.length); n++){
                arr[runningIndex] = matrix[n+1][right];
                runningIndex++;
            }
            for(int n = right-1; n>= left && (runningIndex!= arr.length); n--){
                arr[runningIndex]=matrix[bottom][n];
                runningIndex++;
            }
            for(int n = bottom-1; n >= top+1 && (runningIndex!= arr.length); n--){
                arr[runningIndex] = matrix[n][left];
                runningIndex++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return Arrays.asList(arr);
    }
}