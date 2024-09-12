/**
 * Time Complexity: O(logN) where N is the size of input array
 * Space Complexity: O(1) 
 * LeetCode: Y (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)
 * Approach:
    Observation: If the input array is divided into two halves then at least one of the halves is in entirely sorted order.
    If both the halves are sorted then it implies that the entire range from nums[low] to nums[high] is sorted.
     i.e. the answer is nums[low]
     
    If only one of the halves is sorted then the minimum element lies in the unsorted half.
    Continue discarding one of the halves until you find the minimum element
 */

class Solution {
    public int findMin(int[] nums) {
        // Initiate lower and upper bound for binary search
        int low = 0, high = nums.length - 1;
        
        // Keep searching for the minimum element until a valid search space exists
        while(low <= high) {
            // Calculate mid
            int mid = low + (high - low)/2;
            
            // If the entire range is sorted then the minimum number is the first number of the range
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            // If the middle number is smaller than its neighbors then the middle number is the minimum element
            else if((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // If the left sub-array is sorted then discard the left sub-array because the minimum number will be in the unsorted right sub-array
            else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            // If the right sub-array is sorted then discard the right sub-array because the minimum number will be in unsorted left sub-array
            else {
                high = mid - 1;
            }
            
        }
        
        return -1;
    }
}
