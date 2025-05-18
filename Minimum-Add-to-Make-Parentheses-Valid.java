class Solution {
    public int minAddToMakeValid(String s) {
       int ans=0,bal=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='('){
            ans++;
        }
        else{
            if(ans>0){
                ans--;
            }
            else{
                bal++;
            }
        }
       }
       return ans+bal;
    }
}