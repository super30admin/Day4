//Space Complexity=O(N)
//Time complexity=O(log N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=leftmost(nums,0,nums.length-1,target);//We are creating 2 function to fing right most and left most element in array
        int right=rightmost(nums,0,nums.length-1,target);
        return new int[]{left,right};
    }
    
    //If the mid value is equal to target then we are checking whether its previous is equal to target then putting end to mid-1 and repeating the process similarly for right most element
    private int leftmost(int[] nums, int start,int end, int target)
    {
        int mid;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                if(mid>start && nums[mid-1]==target)
                    end=mid-1;
                else
                    return mid;
            }
            if(target>nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    
    
    private int rightmost(int[] nums, int start,int end, int target)
    {
        int mid;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                if(mid<end && nums[mid+1]==target)
                    start=mid+1;
                else
                    return mid;
            }
            if(target<nums[mid])
                end=mid-1;
            else
                start=mid+1;
                
        }
        return -1;
    }
}