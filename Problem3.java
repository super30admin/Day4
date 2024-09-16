// Time Complexity
// With bruteforce solution: O(n)
// With Binary search Optimization: O(Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1; // Null Conditions
        // Set pointers
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) { // Loop untill low becomes greater than high
            int mid = low + (high - low) / 2; // Calculate mid pointer
            // base case
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid + 1] < nums[mid])) {
                return mid; // Return mid if mid value is greater than its neighbors and if its at low or
                            // high pointers
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) { // Move high pointer if mid is smaller than its neighbors
                                                               // and mid is greater than low pointer
                high = mid - 1;
            } else { // Otherwise Move low pointer
                low = mid + 1;
            }
        }
        return -1;
    }

}