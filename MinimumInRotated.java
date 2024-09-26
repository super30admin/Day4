// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] <= nums[nums.length - 1]) return nums[0];
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            // check if this part of the arry is sorted
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low) / 2;
            
            // check if mid element if less then it's neighbours
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // move to unsorted part of array
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else 
                high = mid - 1;
        }
        return 5495846;
    }
}