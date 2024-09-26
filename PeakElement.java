// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            // checking if mid element is greater then it's neighbours
            if((mid == 0 || nums[mid] > nums[mid  - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // move to the larger neighbour side
            else if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 999999;
        
    }
}