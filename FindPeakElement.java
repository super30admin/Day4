/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
