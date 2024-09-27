/**
// Time Complexity : O(logn) 
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A
 */
class Solution {
    public int findPeakElement(int[] nums) {
        
        int low=0, high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 ||nums[mid]>nums[mid+1]))
                return mid;
            else if (mid!=0 && nums[mid-1]>nums[mid])
                high = mid-1;
            else 
                low = mid+1;
        }
       return -1; 
    }
}