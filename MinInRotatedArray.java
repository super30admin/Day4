// Time Complexity :O(logn) where n is no of elements
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Was unable to manage index 0 and n case but fixed later

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        int n = nums.length - 1;
        while (start <= end) {
            // we'll check if our array is sorted in start to end if yes return start
            // element
            if (nums[start] <= nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            // if mid is at 0 we'll check if mid+1 is greater and if mid is at last
            // index,we'll check mid-1
            // if mid is somewhere in between, we'll check if mid is samller than both mid-1
            // and mid+1 if yes we'll return mid element
            if ((mid == 0 || nums[mid - 1] >= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] >= nums[mid])) {
                return nums[mid];
            }
            // if our start to mid is sorted, we'll shift our start pointer to mid+1
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                // else shift end to mid-1
                end = mid - 1;
            }
        }
        return -1;
    }
}