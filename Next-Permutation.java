class Solution {
    public void nextPermutation(int[] nums) {
        int a=-1;
        int b=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                a=i;
                break;
            }
        }
        if(a==-1){
            reverse(nums,0);
        }
        else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[a]){
                    b=i;
                    break;
                }
            }
            swap(nums,a,b);
            reverse(nums,a+1);
        }
    }
    void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    void reverse(int[] nums, int s){
        int i= s;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}