// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r])
            return nums[l];         //return the first element is array is already sorted
        while (l <= r) {
            int mid = l + (r - l)/2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];           // returning the middle element if it is smaller than both neighbors
            else if (nums[mid] > nums[r])
                l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}