// Time Complexity : O(log n) binary search to find the pivot (minimum element)
// Space Complexity : O(1) in addition to the array provided
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really

class MinimumInSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        return performSearch(nums, left, right);
    }
    
    private int performSearch(int[] nums, int left, int right) {
        if(left <= right) {
            if(nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left)/2;

            if((mid == left || nums[mid] < nums[mid-1]) 
               && (mid == right || nums[mid] < nums[mid+1])) return nums[mid];
            
            if(nums[left] <= nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            
            return performSearch(nums, left, right);
        } else {
            return -1;
        }
    }
}