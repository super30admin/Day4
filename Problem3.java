class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else if (mid != 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }

        }
        return Integer.MAX_VALUE;
    }
}