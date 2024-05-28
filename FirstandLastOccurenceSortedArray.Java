## Problem3 
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// Time Complexity :O(log(n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/* 
 * Move left/right to find the first occurrence
 * Move right/left if the middle element is less/great than the target
 * Move left/right if the middle element is greater/less than the target,Write two functions implementing this logic 
 */
class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        if(nums.length==0||nums==null)
        {
            return new int[] {-1,-1};
        }
        int first=FindFirst(nums,target);
        if(first==-1)
        {
            return new int[]{-1,-1};
        }
        int last=FindLast(nums,target);
        return new int[] {first,last};
    }
    public int FindFirst(int[]nums,int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==0||nums[mid-1]!=target)
                {
                    return mid;
                }
                high=mid-1;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
        return -1;
        
    }
    public int FindLast(int[]nums,int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==nums.length-1||nums[mid+1]!=target)
                {
                    return mid;
                }
                low=mid+1;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}