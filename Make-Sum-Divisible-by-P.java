class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        int length=nums.length;
        for(int i=0;i<length;i++)
        {
            sum+=nums[i];
        }
        int to_rem=(int)(sum%p);
        if(to_rem==0)
          return 0;
        
        HashMap<Integer,Integer> prefixMod=new HashMap<>();
        prefixMod.put(0,-1);
        long prefixSum=0;
        int minLength=length;
        for(int i=0;i<minLength;i++)
        {
            if(length==1)
              return 1;
            prefixSum+=nums[i];
            int currentMod=(int)(prefixSum%p);
            int targetMod=(currentMod-to_rem+p)%p;
            if(prefixMod.get(targetMod)!=null)
            {
                length=Math.min(length,i-prefixMod.get(targetMod));
            }
            prefixMod.put(currentMod,i);
        }
        if(minLength==length)
          return -1;
        else
         return length;
    }
}