public class FindMin {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[start] <= nums[mid]) { // checking for the left sorted part
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
