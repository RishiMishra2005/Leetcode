class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        int n=s1.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                freq[s1.charAt(i)-'a']++;
                freq[s2.charAt(i)-'a']--;
            }
        }
        for(int i:freq){
            if(i!=0){
                count++;
            }
        }
        return count==0 || count==2;
    }
}