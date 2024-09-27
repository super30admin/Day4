
// Time Complexity : O(log n) where n is the size of  array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMin(int[] nums) {
        int low= 0, high = nums.length-1;
        
        while(low<=high)
        {
            
            int mid= low+ (high-low)/2;
            
            if( nums[low]<=nums[high])
                return nums[low];
            
            if(  (mid==nums.length-1 || nums[mid+1]>nums[mid])&& (mid==0 || nums[mid-1]>nums[mid])   )
                 return nums[mid];
            if(nums[low]<=nums[mid])
                low=mid+1;
            else
                high=mid-1;
              
            
        }
        return -1;
    }
}