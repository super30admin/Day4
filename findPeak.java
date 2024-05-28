//time O(log n)
//space O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0; int high = n -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid -1]) && 
               (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid -1] > nums[mid]) {
                high = mid - 1;
            } else if (mid < n -1 && nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            }
        }
        
        return Integer.MIN_VALUE;
    }
}
