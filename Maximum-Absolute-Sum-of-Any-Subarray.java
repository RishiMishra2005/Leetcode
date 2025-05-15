class Solution {
    public int maxAbsoluteSum(int[] a) {
        int n=a.length;
        int tot=0,sum=0;
        int s=a[0];
        int mi=0,ma=0;
        if(a[0]<mi)mi=a[0];
        if(a[0]>ma)ma=a[0];
        for(int i=1;i<n;i++)
        {
            s=s+a[i];
            if(s>ma)ma=s;
            if(s<mi)mi=s;
        }

        return Math.abs(ma-mi);
    }
}