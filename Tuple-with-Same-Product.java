class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product = nums[i]*nums[j];
                count+=(map.getOrDefault(product,0)*8);
                map.merge(product,1,Integer::sum);
            }
        }
        return count;
    }
}