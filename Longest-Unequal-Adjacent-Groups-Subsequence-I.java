class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        for(int i=1;i<groups.length;i++){
            if(groups[i]!=groups[i-1]){
                indexes.add(i);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i:indexes){
            ans.add(words[i]);
        }
        return ans;
    }
}