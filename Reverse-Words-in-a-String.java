class Solution {
    public String reverseWords(String s) {
        String ar[]=s.trim().split("\\s+");
        String a ="";
        for(int i=ar.length-1;i>0;i--){
            a+=ar[i]+" ";
        }
        return a+ar[0];
    }
}