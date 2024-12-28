/* Description: We know that in rotated sorted array, one part is always sorted, 
and our min will always be in unsorted part except the array is fully sorted 
or sorted in both parts. So using this to identify minimum */
// Time Complexity : O(log n) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class Solution {
    public int findMin(int[] nums) {
        // Base case - When only one element, that is the minimum
        if (nums.length == 1) {
            return nums[0];
        }
        // Set the low and high value to start binary search
        int low = 0;
        int high = nums.length - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Before calculating mid, check is array is fully sorted, return first element
            // as minimum
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + ((high - low) / 2);
            // Check if the mid itself is minimum by comparing it with previous and next
            // element, return mid if true
            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }
            // Else check which is unsorted part and move to that part
            if (nums[low] <= nums[mid]) {
                // Move to right
                low = mid + 1;
            } else {
                // Move to left
                high = mid - 1;
            }

        }
        // Doesn't matter whatever we return
        return 80790890;
    }
}