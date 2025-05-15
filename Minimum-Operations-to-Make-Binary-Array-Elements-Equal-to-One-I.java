class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int minCnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0 && i+2<n){                
                nums[i]=nums[i]^1;
                nums[i+1]=nums[i+1]^1;
                nums[i+2]=nums[i+2]^1;

                minCnt++;
            }            
        }

        if(nums[n-2]==0 || nums[n-1]==0){
            return -1;
        }

        return minCnt;
    }
}