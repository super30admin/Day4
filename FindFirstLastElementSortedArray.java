// Time Complexity : O(logn) + O(logn) = O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The approach is to apply binary search starting with low = 0 and high = 0.
 * We apply binary search twice for searching the left most occurance and right side occurance.
 * 
 * For searching the left side occurance, if we find the element at mid, we continue search on the left half of the search space.
 * For searching the right side occurance, if we find the element at mid, we continue search on the right half of the search space.
 * 
 * For the modularity of the code, I have used a single binary search method which decides if we are searching left most or right most occurance based on a boolean flag.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[]{-1, -1};
        
        // base case
        if (nums.length == 0) return res;
        
        int left_occur = searchOccurance(nums, target, true);
        
        if (left_occur == -1) {
            return res;
        }
        
        int right_occur = searchOccurance(nums, target, false);
        
        res[0] = left_occur;
        res[1] = right_occur;
        
        return res;
    }
    
    private int searchOccurance(int[] nums, int target, boolean isLeftSearch) {
        int res = -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                res = mid;
                
                if (isLeftSearch) {
                    // search on the left half
                    high = mid - 1;
                } else {
                    // search on the right half
                    low = mid + 1;
                }
                
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                // target < nums[mid]
                high = mid - 1;
            }
        }
        
        return res;
    }
}