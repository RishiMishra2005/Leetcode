class Solution {
    public int numRabbits(int[] answers) {

        int n = answers.length;
        int[] count = new int[1000];
        
        int ans = 0;
        for(int x:answers){
            if(++count[x] == 1)
                ans += x + 1;
            if(count[x] == x + 1)
                count[x] = 0;
        }
        
        return ans;
    }
}