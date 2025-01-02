// Time Complexity: O(log n)
// Space Complexity: O(1);
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * The algorithm uses binary search to find a peak element in a given array, where a peak is defined as an element that is greater than or equal to its neighbors.
 * At each step, it checks if the middle element is a peak; if not, it narrows the search space to either the left or right half based on the comparison with adjacent elements. 
 */ 

class Solution {
    public int findPeakElement(int[] nums) {

        // If the array is null or empty, return -1
        if(nums == null || nums.length == 0) {
            return -1;
        }

        // Initialize the low, high, and mid pointers for binary search
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        // Perform binary search
        while(low <= high) {

            // Calculate the middle index of the current search range
            mid = low + (high - low) / 2;

            // Check if middle number is peak element
            // The middle element is greater than or equal to its neighbors
            if((mid == 0 || nums[mid] > nums[mid -1 ]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid; // If it's a peak, return the index of the peak
            } 
            // If the element on the right of mid is greater, move the low pointer to the right side
            // This means the peak is in the right half of the array.          
            if(nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // This return value is unreachable because a peak element will always be found in the loop.
        return 456675;
    }
}


            