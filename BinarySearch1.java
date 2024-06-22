// Time Complexity : O(Logn) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//First Approach - that we did in class
//if at given point the give boundry of low and high is sorted -> low element is the minimum
// else we check which side is sorted after calculating mid pointer, then eliminate the sorted half as min will always lie in unsorted side
//repeat binary search
class Solution {
    public int findMin(int[] nums) {
        // Initialize pointers for the beginning (low) and end (high) of the array
        int low = 0;
        int high = nums.length - 1;

        // Binary search loop: continue until the low pointer exceeds the high pointer
        while (low <= high) {
            // If the subarray is already sorted, the smallest element is at the low pointer
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            // Calculate the mid-point of the current subarray
            int mid = low + (high - low) / 2;

            // Check if the mid element is the smallest element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // If the mid element is greater than or equal to the low element, 
            // it means the smallest element is in the right subarray
            else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            }
            // Otherwise, the smallest element is in the left subarray
            else {
                high = mid - 1;
            }
        }

        // This return statement will never be reached if the input array is valid (rotated sorted array)
        return -1;
    }
}




//Second Approach
//Calculate mid
// find sorted half - update minimum with low element of sorted half
// move to another half
//repeat



class Solution {
    public int findMin(int[] nums) {
        // Initialize pointers for the start (low) and end (high) of the array
        int low = 0;
        int high = nums.length - 1;

        // Perform binary search until the low pointer exceeds the high pointer
        while (low <= high) {
            // If the subarray from low to high is already sorted, return the element at the low pointer
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            // Calculate the midpoint of the current subarray
            int mid = low + (high - low) / 2;

            // Check if the midpoint element is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // If the midpoint element is greater than or equal to the low element,
            // it means the smallest element is in the right subarray
            else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            }
            // Otherwise, the smallest element is in the left subarray
            else {
                high = mid - 1;
            }
        }

        // Return -1 as a fallback, although this line should never be reached in a valid rotated sorted array
        return -1;
    }
}
