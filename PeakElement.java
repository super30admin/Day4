class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int lo = 0;
        int hi = nums.length - 1;

        if (nums.length == 1) {
            return 0;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid + 1] > nums[mid]) {
                    lo = mid + 1;
                } else
                    hi = mid - 1;

            }

            else if (mid == 0) {
                if (nums[mid] > nums[1])
                    return mid;
                else
                    return 1;
            }

            else if (mid == nums.length - 1) {
                if (nums[mid] > nums[nums.length - 2])
                    return mid;
                else
                    return nums.length - 2;
            }

        }
        return -1;
    }
}