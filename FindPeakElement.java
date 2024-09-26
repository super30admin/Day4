// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    The peak element is larger than its neighbours (if exists)
    If nums[mid-1]>nums[mid]>nums[mid+1], we move towards left
    Else we move right
    The logic being - the peak would lie in the direction of the increase in array.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        
        int l = 0;
        int r = nums.length-1;
        int mid;
        
        while(l<=r){
            
            mid = l+(r-l)/2;
            
            if (mid == 0 && nums[mid]>nums[mid+1]) return mid;
            if (mid == nums.length-1 && nums[mid]>nums[mid-1]) return mid;  
            if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            
            if (nums[mid]>nums[mid+1]) r = mid-1;
            else l = mid+1;
        }
        
        return l;
    }
}
