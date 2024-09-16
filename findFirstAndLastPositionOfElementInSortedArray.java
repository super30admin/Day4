// Time Complexity : O(logn) where n is length of the nums array. // worst case-all the elements are traversed- O(n)
// Space Complexity : O(1) stack space in recursion( max 2 calls in stack at once)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach

class Solution {
    int start, end;

    public int[] searchRange(int[] nums, int target) {
        // nums is empty or target is out of range
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[] { -1, -1 };
        start = nums.length;
        end = -1;
        binarySearch(nums, target, 0, nums.length - 1);
        // if element not found, start not updated
        return (start == nums.length) ? new int[] { -1, -1 } : new int[] { start, end };
    }

    private void binarySearch(int[] nums, int target, int i, int j) {
        // base
        if (i > j || i < 0 || i >= nums.length)
            return;
        // logic
        int mid = i + (j - i) / 2;
        if (nums[mid] == target) {
            // update start and end, everytime value is found
            start = Math.min(start, mid);
            end = Math.max(end, mid);
            // continue traverse on left(mid-1 is target )
            if (mid - 1 >= i && nums[mid - 1] == target)
                binarySearch(nums, target, i, mid - 1);
            // continue traverse on right(mid+1 is target )
            if (mid + 1 <= j && nums[mid + 1] == target)
                binarySearch(nums, target, mid + 1, j);
        }
        // normal binary search logic
        else if (target < nums[mid])
            binarySearch(nums, target, i, mid - 1);
        else
            binarySearch(nums, target, mid + 1, j);
    }
}