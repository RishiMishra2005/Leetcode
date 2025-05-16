class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum^=derived[i];
        }
        return sum==0;
    }
}