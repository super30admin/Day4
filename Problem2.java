//Problem 2: Find minimum in rotated sorted array
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) { // We search till left boundary is less than right boundary
            int mid = left + (right - left)/2;
            // We figure out the unsorted half of the current problem space (left..mid..right)
            if (nums[mid] > nums[right]) {
                // We exclude mid from the solution space since we know it is not the minimum element
                left = mid + 1; 
            }
            else {
                // We know the solution space is the left half of the sub-array, including mid
                right = mid;
            }
        }
        // Here left = right
        return nums[left]; 
    }
}