class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int low = 0, high = nums.length-1, mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            if ((mid-1 < 0 || nums[mid] > nums[mid-1]) && (mid+1 >= nums.length || nums[mid] > nums[mid+1]))
                return mid;
            if (nums[mid] < nums[mid+1])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}