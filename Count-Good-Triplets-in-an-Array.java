class Solution 
{
    public long goodTriplets(int[] nums1, int[] nums2) 
    {
        int n = nums1.length;
        int[] pos2 = new int[n], reversedIndexMapping = new int[n];
        
        for (int i = 0; i < n; i++) 
        {
            pos2[nums2[i]] = i;
        }
        for (int i = 0; i < n; i++) 
        {
            reversedIndexMapping[pos2[nums1[i]]] = i;
        }
        
        FenwickTree tree = new FenwickTree(n);
        long res = 0;
        for (int value = 0; value < n; value++) 
        {
            int pos = reversedIndexMapping[value];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (value - left);
            res += (long) left * right;
        }
        return res;
    }

    private class FenwickTree 
    {
        private int[] tree;

        public FenwickTree(int size) 
        {
            this.tree = new int[size + 1];
        }

        public void update(int index, int delta) 
        {
            index++;
            while (index < tree.length) 
            {
                this.tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) 
        {
            index++;
            int res = 0;
            while (index > 0) 
            {
                res += this.tree[index];
                index -= index & -index;
            }
            return res;
        }
    }
}