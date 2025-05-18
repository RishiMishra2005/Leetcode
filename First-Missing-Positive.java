class Solution {
    public int firstMissingPositive(int[] nums) {
         int n = nums.length;
     int i = 0;
    while(i < n){ 
        int s = nums[i]-1;
        if (nums[i] > 0 && nums[i] < n && nums[i] != nums[s]) {
                swap(nums, i, s);
        }else{
            i++;
        }
    } 
    for(int j = 0; j < n; j++){
        if(nums[j] != j + 1){
            return j+1; 
        }
    }
    return n + 1;

    

    }
   public void swap(int[] nums, int start, int end){
    int temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
    }
}