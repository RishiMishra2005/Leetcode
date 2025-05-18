class Solution {
    public boolean canJump(int[] nums) {
        boolean flg=false;
        int cur=0;
        if(nums.length==1) return true;
        nums[nums.length-1]+=1;
        for(int i=nums.length-1;i>=0;i--){
            if(!flg&&nums[i]==0){
                cur=2;
                flg=true;
                continue;
            }
            if(flg&&nums[i]>=cur)
                flg=false;
            else
                cur++;
        }
        nums[nums.length-1]-=1;
        if(flg) return false;
        return true;
    }
}