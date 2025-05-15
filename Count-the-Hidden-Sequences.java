class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, min=0,max=0;
        for (var x : differences) {
            sum += x; 
            min = Math.min(min, sum);   
            max = Math.max(max, sum);   
        }
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}