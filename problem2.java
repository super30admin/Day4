//Time Complexity - O(logn)
//space Complexity - O(1)

class Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;


        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 ||
                    nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 4565465;
    }
}