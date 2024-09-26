// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n


class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high = nums.length-1;
        int mid;
        if(nums.length==0)
        {
            return -1;
        }
        
        if(nums[high]>nums[low]){
            return nums[low];
        }
        while(high>low)
        {
            
            mid= low +(high-low)/2;
            
            
            if(nums[mid]<nums[high])
            {
               high=mid; 
            }
            else
            {
                low= mid+1;
            }
        }
        return nums[low];
        
    }
}
