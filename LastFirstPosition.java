class LastFirstPosition {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return new int[]{-1,-1};
        int left = 0, right = nums.length;
         while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        int end = left - 1;
        if (end == -1 || nums[end] != target)
            return new int[]{-1,-1};
        
        left = 0; right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return new int[]{left, end};
    }
}