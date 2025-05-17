class Solution {
    public int maxPoints(int[][] points) {
        int m=points.length;
        if (m<2)
        {
            return m;
        }
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                int x1=points[i][0],y1=points[i][1],x2=points[j][0],y2=points[j][1];
                int count=2;
                for(int k=j+1;k<m;k++)
                {
                    int x3=points[k][0],y3=points[k][1];
                    if ((x2-x1)*(y3-y1)==(x3-x1)*(y2-y1))
                    {
                        count ++;
                    }
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }
}