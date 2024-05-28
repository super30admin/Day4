//time O(log n)
//space O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int low = 0; int high = n -1;
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid - 1] > nums[mid]) && 
               (mid == n-1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }
            //left side sorted
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        return Integer.MAX_VALUE;
    }
}
