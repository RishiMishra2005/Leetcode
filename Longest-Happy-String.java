class Solution {
    public String longestDiverseString(int a, int b, int c) {
    int currA =0, currB = 0, currC = 0;
    int maxLen = a+b+c, i=0;
    StringBuilder sb = new StringBuilder(); 
    while(i<(maxLen))
    {
      if(currA!=2 && a>=b && a>=c ||  a>0 && (currB==2 || currC==2))
      {
      sb.append('a');
      currA++; 
      currB=0;
      currC=0;
      a--;
      }

      else if(currB!=2 && b>=a && b>=c ||  b>0 && (currA==2 || currC==2))
      {
      sb.append('b');
      currB++; 
      currA=0;
      currC=0;
      b--;
      }

     else if(currC!=2 && c>=a && c>=b ||  c>0 && (currA==2 || currB==2))
      {
      sb.append('c');
      currC++; 
      currA=0;
      currB=0;
      c--;
      }
     i++;
    }
      return sb.toString();
    }
}