// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid - 1;

        }
        return -1;
    }
}