// Find Minimum in Rotated Sorted Array
// Time Complexity: O(log N)
// Space Complexity:O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}