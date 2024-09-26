// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    The target in this case is that, the value must be smaller than both the neighbours (if exists)
*/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int l = 0;
        int r = nums.length-1;
        int mid = l+(r-l)/2;
        
        while(l<=r){
            
            mid = l+(r-l)/2;
            
            if (0<=mid-1 && mid+1<=nums.length-1)
                if (nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) return nums[mid];
            
            if (nums[mid]>nums[r]) l = mid+1;
            else r = mid-1;
        }
        
        return nums[mid];
    }
}