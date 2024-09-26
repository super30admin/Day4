
// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Use single function and check both start and end by using a single condition
        int start = findPosition(nums, target, true);
        // if the element is not found for the first occurence no need to check for the
        // last occurence
        if (start == -1)
            return new int[] { -1, -1 };
        int end = findPosition(nums, target, false);
        return new int[] { start, end };
    }

    private int findPosition(int[] nums, int target, boolean start) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // check the start index
            // loop untill mid index is the first occurence
            if (start) {
                if (target > nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            // check the end index
            // loop untill mid index is the last occurence
            else {
                if (target >= nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }
}