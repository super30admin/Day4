/*
Leet Code Problem 34
Find First and Last Position of Element in Sorted Array
Language Used : Java
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42 MB, less than 84.14% of Java online submissions for Find First and Last Position of Element in Sorted Array.


Logic: One binary search to find the right index and one to find the left index
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int left=-1;
        int right=-1;
        //null check
        if(nums==null||nums.length==0) 
            return new int[]{-1,-1};
        if(target<nums[low]||target>nums[high])
            return new int[]{-1,-1};
        //Binary search for left
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] ==target)
            {
                if(mid==0||nums[mid]>nums[mid-1])
                {left=mid;break;} 
                
                else
                    high=mid-1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
               low = mid +1; 
            }
        }
        //Binary search for right
        low=0;
        high=nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] ==target)
            {
                if(mid==nums.length-1||nums[mid]<nums[mid+1])
                {right=mid;break;} 
                else
                    low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
               low = mid +1; 
            }
        }
        
        return new int [] {left,right};
        
        
    }
}