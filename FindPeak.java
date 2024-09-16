public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
                return mid;
            }
            else if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 36367363;
    }
}