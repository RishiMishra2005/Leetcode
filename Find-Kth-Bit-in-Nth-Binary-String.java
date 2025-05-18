class Solution {
    public char findKthBit(int n, int k) {
    int invert = 0, len = (1<<n)-1 ;
    while(k>1)
    {
      if(k==len/2+1)
      return invert%2==0 ? '1' : '0' ; 
     else if(k>len/2+1)
      {
      k = len-k+1;
      invert++;
      } 
      len = len/2;
    }  

    return invert%2==0 ? '0' : '1'; 

    }
}