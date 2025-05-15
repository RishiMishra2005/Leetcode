class Solution
{
    public String pushDominoes(String dominoes)
    {
        int p = -1;
        char d = 0;
        char [] c = dominoes.toCharArray();
        int l = c.length;

        for(int i=0; i<l; i++)
            switch(c[i])
            {
                case 'L' ->
                {
                    if(p==-1 || d=='L')
                        for(int j=i-1; j>p; j--)
                            c[j] = 'L';

                    else for(int j=p+1, k=i-1; j<k; j++, k--)
                    {
                        if(j==k)
                            c[j] = '.';

                        else
                        {
                            c[j] = 'R';
                            c[k] = 'L';
                        }
                    }

                    d = 'L';
                    p = i;
                }

                case 'R' ->
                {
                    if(d=='R')
                        for(int j=p+1; j<i; j++)
                            c[j] = 'R';

                    d = 'R';
                    p = i;
                }
            }

        if(d=='R')
            for(int i=l-1; i>=0; i--)
            {
                if(c[i]=='.')
                    c[i] = 'R';

                else break;
            }

        return new String(c);
    }
}