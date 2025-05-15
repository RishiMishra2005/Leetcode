class Solution {
    public int countCompleteSubarrays(int[] nums) {
        boolean[] exists = new boolean[2001];
        int distinct = 0;
        for( int n : nums ){
            if( !exists[n] ){
                exists[n] = true;
                distinct++;
            }
        }
        int[] freq = new int[2001];
        int count = 0, n = nums.length;
        int sub = 0;
        for( int start = 0, end = 0; end < n; end++ ){
            if( freq[ nums[ end ] ]++ == 0 )
                count++;
            while( count == distinct ){
                sub += n - end;
                if( freq[ nums[ start ++ ] ]-- == 1 )
                    count--;
            }
        }
        return sub;
    }
}