class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int cnt=0;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    boolean isPrefixAndSuffix(String str1, String str2){

        if (str2.startsWith(str1) && str2.endsWith(str1) ){
            return true;
        }

        return false;
    }
}