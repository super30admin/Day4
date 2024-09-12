public class PeakElement {
    public int peak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums.length == 1)
                return 0;
            if (mid == 0 && nums[mid + 1] < nums[mid])
                return mid;
            if (mid == nums.length - 1 && nums[mid - 1] < nums[mid])
                return mid;
            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid] && mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid + 1] < nums[mid] && nums.length == 2) {
                return mid - 1;
            }
            if (nums[mid + 1] < nums[mid]) {
                end = mid;
            } else if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            }

        }
        return -1;
    }
}
