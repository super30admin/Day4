class Solution {
    // TC: O(log n)
    // SC: O(1)
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid]))
                return nums[mid];
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return 345678;
    }
}
