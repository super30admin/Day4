//162. Find Peak Element

class Exercise3 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (((mid == right) || (nums[mid] > nums[mid + 1])) &&
                    ((mid == left) || (nums[mid - 1] < nums[mid]))) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}