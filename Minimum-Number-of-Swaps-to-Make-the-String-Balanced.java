class Solution {
    public int minSwaps(String s) {
        int a=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='['){
                a++;
            }
            else if(a>0){
                a--;
            }
        
    }
    return (a+1)/2;
}
}