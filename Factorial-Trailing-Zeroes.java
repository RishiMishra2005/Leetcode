class Solution {
    public int trailingZeroes(int n) {
        int x=0;
        for(int i=5;i<=n;i*=5){
            x+=n/i;
        }
        return x;
    }
}