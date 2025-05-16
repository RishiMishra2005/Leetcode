class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length < 10000){
            Arrays.sort(nums);
            int longest = 0;
            int current = 0;
            int prev = nums[0] - 2;
            for(int num : nums){
                if(num == prev)continue;
                if(num - prev == 1){
                    current += 1;
                }
                else{
                    longest = Math.max(longest, current);
                    current = 1;
                }
                prev = num;
            }
            return Math.max(longest, current);
        }
        else{
            int min = nums[0];
            int max = nums[0];
            for(int num : nums){
                if(num < min){
                    min = num;
                }
                else if(num > max){
                    max = num;
                }
            }
            int range = max - min + 1;
            boolean[] isObserved = new boolean[range + 1];
            for(int num : nums){
                int index = (num - min);
                isObserved[index] = true;
            }

            int longest = 0;
            int current = 0;
            for(boolean _isObserved : isObserved){
                if(_isObserved){
                    current += 1;
                }
                else{
                    longest = Math.max(longest, current);
                    current = 0;
                }
            }

            return Math.max(longest, current);
        }
    }
}