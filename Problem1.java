// Time Complexity : O(logn + logn) == O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
* This solution is based on Two pass binary search.
* First Binary search will be to find the right position of the target
* Secondary Binary search will be to find the left position of the target
**/

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int start_index = -1;
        int end_index = -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        // Find the left-most index for the element
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                
                if(mid-1 < low) {
                    start_index = mid;
                    break;
                }
                if(nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    start_index = mid;
                    break;
                }
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        low = 0;
        high = nums.length - 1;
        
        // Find the right-most index for the element
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                if(mid+1 > high) {
                    end_index = mid;
                    break;
                }
                
                if(nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    end_index = mid;
                    break;
                }
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return new int[]{start_index, end_index};
    }
}