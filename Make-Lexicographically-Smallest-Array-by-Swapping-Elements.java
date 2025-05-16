class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
                int[] map = new int[n];
                        List<int[]> pairs = new ArrayList<>();
                                for (int i = 0; i < n; ++i) {
                                            pairs.add(new int[]{nums[i], i});
                                                    }
                                                            pairs.sort((a, b) -> Integer.compare(a[0], b[0]));
                                                                    List<int[]> sets = new ArrayList<>();
                                                                            sets.add(new int[]{n - 1, n - 1});
                                                                                    for (int i = n - 2, group = 0; i >= 0; --i) {
                                                                                                if (pairs.get(i + 1)[0] - pairs.get(i)[0] <= limit) {
                                                                                                                sets.get(sets.size() - 1)[0] = i;
                                                                                                                                map[pairs.get(i)[1]] = group;
                                                                                                                                            } 
                                                                                                                                                        else {
                                                                                                                                                                        sets.add(new int[]{i, i});
                                                                                                                                                                                        map[pairs.get(i)[1]] = ++group;
                                                                                                                                                                                                    }
                                                                                                                                                                                                            }
                                                                                                                                                                                                                    for (int i = 0; i < n; ++i) {
                                                                                                                                                                                                                                int groupId = map[i];
                                                                                                                                                                                                                                            nums[i] = pairs.get(sets.get(groupId)[0]++)[0];
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                            return nums;
    }
}