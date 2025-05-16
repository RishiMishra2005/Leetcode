class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        int pro=1;
        for(int i=0;i<n;i++){
            pro *=nums[i];
            mx=Math.max(mx,pro);
           if(pro==0) pro=1;
        }
        pro=1;
        for(int i=nums.length-1; i>=0;i-- ){
            pro *=nums[i];
            mx=Math.max(mx,pro);
           if(pro==0) pro=1;
        }
        return mx;
    }
}