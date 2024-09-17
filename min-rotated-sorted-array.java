//Time complexity is Log(n)
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0]; // if only 1 element, we return that
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2; // prevent integer overflow
            System.out.println("low is " + low + "high: " + high + "mid " + mid);

            if ((mid == nums.length - 1 || nums[mid] < nums[mid + 1]) && (mid == 0 || nums[mid] < nums[mid - 1])) {
                System.out.print("mid is " + mid);
                return nums[mid];
            }

            if (nums[low] <= nums[mid]) {
                // sorted
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}