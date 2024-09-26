// Time Complexity :O(log n)
// Space Complexity :O(1) As array is not an Auxiliary  space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -
class Solution {
    
    //binary search for first index
    private int binarySearchFirst(int[] nums,int target)
    {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2; // find mid
            if(nums[mid]==target) // if mid matches target
            {
                if(mid==0 || nums[mid-1]<nums[mid]) // if mid is the first index in the array or if nums[mid] is the first occurrence
                {
                    return mid;
                }
                else
                {
                    end=mid-1; // if mid is not the first occurrence of the target,search the array before the mid index for first occurrence
                }
            }
            else if(nums[mid] < target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    
    
     //binary search for last index
    private int binarySearchLast(int[] nums,int target)
    {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2; // find mid
            if(nums[mid]==target) // if mid matches target
            {
                if(mid==nums.length-1 || nums[mid+1]>nums[mid])// if mid is the last index in the array or if nums[mid] is the last occurrence
                {
                    return mid;             
                }
                else
                    start=mid+1; // look for last occurrence after the mid
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
        
    }
    
    public int[] searchRange(int[] nums, int target) 
    {
        int start=0;
        int end=nums.length-1;
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int first=binarySearchFirst(nums,target);
        int last=binarySearchLast(nums,target);
        return new int[]{first,last};
    }
}