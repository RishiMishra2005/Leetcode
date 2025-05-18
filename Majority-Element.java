class Solution {
    public int majorityElement(int[] nums) {
        int a=0,majority=0;
        for(int n: nums){
            if(majority==0){
                a=n;
            }
            majority +=n == a ? 1 : -1;
        }
        return a;
    }
}