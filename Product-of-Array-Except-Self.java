class Solution {
    public int[] productExceptSelf(int[] nums) {
        int a[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i]=1;
        }
        int left=1;
        for(int i=0;i<nums.length;i++){
            a[i]*=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            a[i]*=right;
            right*=nums[i];
        }
        return a;
    }
}