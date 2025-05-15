class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index==nums.length){
            List < Integer > ds = new ArrayList < > ();
            for (int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
                ans.add(ds);
                return;
        }
        for (int i=index;i<nums.length;i++){
            swap(nums,index, i);
            recurPermute(index+1, nums, ans);
             swap(nums,index, i);
        }
    }

    private void swap(int[] nums,int index, int i ){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i]=temp;

    }
}