class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        // Arrays to store less-than-pivot and greater-than-pivot elements
        int[] less = new int[n];
        int[] high = new int[n];
        int[] result = new int[n];

        // Counters for different parts of the array
        int count = 0; // To count the number of pivot elements
        int j = 0; // Index for the 'less' array
        int k = 0; // Index for the 'high' array

        // Partition the input array into 'less', 'high', and count pivot occurrences
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                less[j++] = nums[i];
            } else if (nums[i] == pivot) {
                count++;
            } else {
                high[k++] = nums[i];
            }
        }

        // Fill the result array
        int index = 0;

        // Add elements less than the pivot
        for (int a = 0; a < j; a++) {
            result[index++] = less[a];
        }

        // Add the pivot element `count` times
        for (int a = 0; a < count; a++) {
            result[index++] = pivot;
        }

        // Add elements greater than the pivot
        for (int a = 0; a < k; a++) {
            result[index++] = high[a];
        }

        return result;
    }
}