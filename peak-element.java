//time complexity: O(log n)
//space complexity: O(1)
//Did it run successfully on leetcode: YES

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; //return mid if its the peak element
            } else if(nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 1;
    }
}