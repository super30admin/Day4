// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == 0) if(nums[0] > nums[1]) return 0; else return 1;
            if(mid == n-1) if(nums[n-1] > nums[n-2]) return n-1; else return n-2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            if(nums[mid] < nums[mid - 1]) high = mid - 1; //go to greater element
            else low = mid + 1;
        }
        return -1;
    }
}