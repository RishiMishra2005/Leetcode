class Solution {
    public int minCapability(int[] a, int k) {
        int n = a.length;
        int lo = Integer.MAX_VALUE;

        for(int  x: a) lo = Math.min(lo, x);
        int hi = 0;
        for(int x: a) hi = Math.max(hi, x);

        int ans = 0;
        while(hi >= lo){
            int mid = (lo + hi) / 2;
            int max = 0;

            for(int i = 0; i < n ;i++){
                if(a[i] <= mid){
                    i++;
                    max++;
                }
            }

            if(max >= k){
                hi = mid - 1;
                ans = mid;
            }
            else lo = mid + 1;
        }
        return ans;       
    }
}