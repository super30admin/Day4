/**
// Time Complexity : O(logn) 
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first_occ = findBound(nums,target,true);
        if(first_occ==-1)
            return new int[]{-1,-1};
        
        int last_occ = findBound(nums,target,false);
        
        return new int[]{first_occ,last_occ};
        
    }
    
    private int findBound(int[] nums, int target, boolean isFirst)
    {
        int low=0, high=nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(isFirst)
            {
                if(nums[mid]==target)
                {
                    if(mid==low || nums[mid]!=nums[mid-1])
                        return mid;
                    else
                        high = mid-1;
                }else
                {
                    if(target<nums[mid])
                        high=mid-1;
                    else
                        low=mid+1;
                }
            }
            else
            {
                if(nums[mid]==target)
                {
                    if(mid==high || nums[mid]!=nums[mid+1])
                        return mid;
                    else
                        low=mid+1;
                }else
                {
                    if(target<nums[mid])
                        high = mid-1;
                    else
                        low = mid+1;
                }
            }
        }
        return -1;
    }
}