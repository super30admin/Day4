// Time Complexity
// With bruteforce solution: O(n)
// With Binary search Optimization: O(Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) // Null conditions
            return -1;
        int low = 0; // Set low and high pointers
        int high = nums.length - 1;
        while (low <= high) { // Loop untill low becomes greater than high
            int mid = low + (high - low) / 2; // Calculate mid pointer
            if (nums[low] <= nums[high]) // Check if array isn't rotated
                return nums[low];
            if ((nums[mid] < nums[mid + 1] || mid == nums.length - 1) && // Condition to divide search space by half
                    (mid == 0 || nums[mid] < nums[mid - 1])) { // Check if mid value is smaller than its neighbors and
                                                               // if its at low or high pointers
                return nums[mid];
            } else if (nums[low] <= nums[mid]) { // left sorted
                low = mid + 1;
            } else { // Right sorted
                high = mid - 1;
            }
        }
        return 5001;
    }
}