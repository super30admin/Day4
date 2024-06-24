
class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int n = nums.length - 1;
        int right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == n) {
                return mid;
            }
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid != n && nums[mid + 1] > nums[mid]) {
                left = mid + 1;

            } else {
                return mid;
            }

        }//while
        return -1;

    }
}
