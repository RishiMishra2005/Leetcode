class Solution {
    private int firstOccurance(int[] nums, int target) {
        int answer = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low) + ((high-low)/2);
            if(nums[mid]==target) {
                answer = mid;
                high = mid-1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }

    private int lastOccurance(int[] nums, int target) {
        int answer = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low) + ((high-low)/2);
            if(nums[mid]==target) {
                answer = mid;
                low = mid+1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = firstOccurance(nums, target);
        if(answer[0]==-1) {
            answer[1] = -1;
        } else {
            answer[1] = lastOccurance(nums, target);
        }
        return answer;
    }
}