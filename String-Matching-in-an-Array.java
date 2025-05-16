class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (isSubstringOfSomeoneButIt(words, curr, i)) {
                result.add(curr);
            } 
        }

        return result;
    }

    private static boolean isSubstringOfSomeoneButIt(String[] words, String curr, int indexToExclude) {
        for (int j = 0; j < words.length; j++) {
            if (j == indexToExclude)
                continue;
            String other = words[j];
            if (other.contains(curr)) { // TODO is null allowed ?
                return true;
            }
        }

        return false;
    }
}