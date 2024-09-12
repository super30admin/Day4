// Time Complexity: O(logn)
// Space Complexity: O(1)
// LeetCode: Y (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
/* Approach: 
    Modify the normal binary search algorithm to that returns the first occurence of target >= 1
    Call the modified binary search to find the firstOccurence of a number >= target
    If the target was found then call the modified binary search to find the firstOccurence of a number >= (target + 1)
    If the target was not found in the first call to modified binary search then return { -1, -1 } 
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Find first Occurence of target
        int firstOccurence = binarySearchModified(nums, target);
        
        // If the first Occurence of the target was found in the nums array then return firstOccurence and lastOccurence
        if(firstOccurence < nums.length && nums[firstOccurence] == target) {
            // Find first Occurence of a number >= (target + 1) and subtract 1 to get the lastOccurence of target
            int lastOccurence = binarySearchModified(nums, target + 1) - 1;
            return new int[]{ firstOccurence, lastOccurence };
        }
        
        // Target number does not exist in the nums array
        return new int[]{-1, -1};
    }
    
    
    /** Helper function that finds the index of a number >= target in the nums array */
    private int binarySearchModified(int[] nums, int target) {
        // Set lower bound
        int low = 0;
        
        // Set upper bound
        int high = nums.length - 1;
        
        // Find target until a valid range remains to search
        while(low <= high) {
            
            // Calculate middle of lower and upper bound
            int mid = low + (high - low) / 2;
            
            // If target is discovered then discard the right of the array
            if(nums[mid] >= target) {
                high = mid - 1;
            }
            // If the target is not in the first half of the array then discard the first half of the array
            else {
                low = mid + 1;
            }
        }
        
        return low;
        
    }
}
