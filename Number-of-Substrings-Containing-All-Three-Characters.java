class Solution {
    public int numberOfSubstrings(String s) {
        char[] ch = s.toCharArray();
        int[] abc = new int[3];
        for(int i=0; i<abc.length; i++)
        {
            abc[i] = -1;
        }
        int count = 0, right = 0;
        while(right < ch.length)
        {
            abc[ch[right] - 'a'] = right;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<3; i++)
            {
                min = Math.min(min, abc[i]);
            }
            count += (min+1);
            right++;
        }
        return count;
    }
}