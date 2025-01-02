// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * This is a problem of find minimum in rotated sorted array. The algorithm uses binary search to find the minimum element in a rotated sorted array.
 * It checks if the array is already sorted by comparing the first and last elements, and if not, it looks for the point where the rotation occurs by 
 * comparing elements around the middle.
 */ 

class Solution {
    public int findMin(int[] nums) {

        // If the array contains only one element, return that element
        if(nums.length == 1) {
            return nums[0];
        }

        // Initialize low and high pointers for binary search
        int low = 0;
        int high = nums.length-1;

        // Start binary search to find the minimum element
        while(low <= high) {
            
            // Check if the subarray is already sorted 
            if(nums[low] <= nums[high]) {
                return nums[low];
            }

            // Calculate the middle index of the current subarray
            int mid = low + (high - low) / 2;
            
            // Check if mid element is the smallest element
            // If mid is the first element or its previous element is greater, it could be the smallest.
            // If mid is the last element or its next element is greater, it could also be the smallest.
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }

            // If the left half is sorted, the minimum element must lie in the right half (after mid), so we update low
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            // Otherwise, the right half is sorted, so the minimum element must be in the left half    
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}

