// Time Complexity : O(Logn) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Compute the mid, check if its the peak
//if not move toward high slope
//repeat
class Solution {
    
    // Method to find a peak element in the array
    public int findPeakElement(int[] nums) {
        int low = 0; // Initialize low pointer
        int high = nums.length - 1; // Initialize high pointer

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid index

            // Check if the mid element is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Return the index if it's a peak
            }

            // If the mid element is greater than the previous element,
            // search in the right half
            else if (mid == 0 || nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }

            // If the mid element is not greater than the previous element,
            // search in the left half
            else {
                high = mid - 1;
            }
        }

        return 0; // Default return value (should never reach here)
    }
}
