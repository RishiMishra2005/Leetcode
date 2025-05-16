class Solution {
    public int maximumSum(int[] nums) {
        int[] memo = new int[82] ; 
        int rs = -1; 
        for( int num : nums ){
            int a = num ; 
            int curr = 0 ;
            while(a>0){
                curr += a%10 ; 
                a /= 10 ;
            }  
            int prev = memo[curr] ; 
            if( prev != 0 ){
                rs = Math.max( rs , num + prev ) ; 
                memo[curr] = Math.max( prev , num ) ; 
            }else {
                 memo[curr] = num ;
            }
        }
        return rs ;
    }
}