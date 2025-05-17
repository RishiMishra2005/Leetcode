class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb= new StringBuilder();
        int c=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0 || j>=0 || c==1){
            if(i>=0){
                c+=a.charAt(i--)-'0';
            }
            if(j>=0){
                c+=b.charAt(j--)-'0';
            }
            sb.append(c%2);
            c/=2;
        }
        return sb.reverse().toString();
    }
}