class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while(i < m && j < n){
            if(nums1[i][0] == nums2[j][0]){
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++; j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                result.add(nums1[i]);
                i++;
            }
            else{
                result.add(nums2[j]);
                j++;
            }
        }
        while(i < m){
            result.add(nums1[i]);
            i++;
        }
        while(j < n){
            result.add(nums2[j]);
            j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}