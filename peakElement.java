class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int n = nums.length - 1;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((mid == low || nums[mid+1] < nums[mid]) && (mid == high ||nums[mid] > nums[mid-1])) 
                return mid;
            else if (mid == high || nums[mid+1] > nums[mid]) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return 76589;
    }
}