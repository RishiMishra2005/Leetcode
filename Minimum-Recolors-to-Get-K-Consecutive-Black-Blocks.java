class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int wCnt=0;
        for(int l=0; l<k; l++){
            if(blocks.charAt(l)=='W'){
                wCnt++;
            }
        }
        
        int i=1, j=k;
        int cnt=wCnt;
        while(i<n && j<n){
            if(blocks.charAt(i-1)=='W'){
                wCnt-=1;
            }
            if(blocks.charAt(j)=='W'){
                wCnt+=1;
            }
            cnt=wCnt<cnt?wCnt:cnt;
            i++; j++;
        }
        return cnt;
    }
}