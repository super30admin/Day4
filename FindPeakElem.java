// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l)/2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;                             //checking if mid is greater than its neighbors
            else if (nums[mid] < nums[mid + 1])         //we move to right if right element is greater else to the left
                l = mid + 1;
            else r = mid;
        }
        return -1;
    }
}