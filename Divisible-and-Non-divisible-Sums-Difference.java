class Solution {
    public int differenceOfSums(int b, int v) {
        int k = b / v;
        return (b *(b + 1))/ 2 - k * (k+ 1)* v;
    }
}