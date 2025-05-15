class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recWay1(s, wordDict);
    }

    boolean recWay2(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak2(s, new HashSet<>(wordDict), 0, memo);
    }

    boolean wordBreak2(String s, Set<String> wordDict, int k, Boolean[] memo) {
        int n = s.length();
        if (k == n) return true;

        if (memo[k] != null) return memo[k];

        for (int i=k + 1; i<=n; i++) {
            String word = s.substring(k, i);
            if (wordDict.contains(word) && wordBreak2(s, wordDict, i, memo)) {
                return memo[k] = true;
            }
        }

        return memo[k] = false;
    }

    boolean recWay1(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak(s, wordDict, 0, memo);
    }
    
    boolean wordBreak(String s, List<String> wordDict, int k, Boolean[] memo) {
        if (k == s.length()) {
            return true;
        }
        
        if (memo[k] != null) {
            return memo[k];
        }
        
        for (int i=0; i<wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, k)) {
                if(wordBreak(s, wordDict, k + word.length(), memo)) return memo[k] = true;
            }
        }
                   
        return memo[k] = false;
    }
}