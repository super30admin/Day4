//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix


class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1])
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}
