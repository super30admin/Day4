class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        while (low <= high) {
            // if sorted itself
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == low || nums[mid] < nums[mid -1]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if(nums[low] > nums[mid]) { // left side is not sorted because min will be in unsorte side
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
