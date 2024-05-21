// Time Complexity : O(log n)
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: As per observation, one side will be sorted and the minimum element will be always on the sorted side.
To check if left side is sorted, then compare low with mid and if sorted move to the right side to find the minimum element
 */

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[high])
                return nums[low];
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return -1;
    }
}