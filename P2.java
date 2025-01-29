class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) { 
            int mid = low + (high - low) / 2;

            // If the middle element is greater than the last element, 
            // the minimum is in the right part
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else { 
                // Otherwise, the minimum is in the left part (including mid)
                high = mid;
            }
        }
        return nums[low]; // At the end of the loop, `low == high`, pointing to the minimum
    }
}
