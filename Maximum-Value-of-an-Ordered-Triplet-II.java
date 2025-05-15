class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxProduct=0;
        int maxDiff=0;
        int maxNum=0;
        for(int num: nums){
            maxProduct = Math.max(maxProduct, (long)maxDiff*num);
            maxNum = Math.max(maxNum, num);
            maxDiff = Math.max(maxDiff, maxNum-num);
        }
        return maxProduct>0?maxProduct:0;
    }
}