Time Complexity :O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = { -1, -1 };
        if (nums.length == 0 || nums == null)
            return result;
        // traverse using  binary search and if mid element is target and either is at 0 index or mid-1 element is diffrent, we store index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == 0 || nums[mid] != nums[mid - 1])) {
                result[0] = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        // apply binary search and if mid element is target and either is at n-1 index or mid+1 element is diffrent, we store index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                result[1] = mid;
                break;
            } else if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}

