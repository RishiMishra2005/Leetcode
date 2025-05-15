class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];

        for(int i = 0; i<nums.length; i++){
            freq[nums[i]]++;
        }

        for(int i = 0; i<501; i++){
            if(freq[i]%2 != 0){
                return false;
            }
        }

        return true;
    }
}