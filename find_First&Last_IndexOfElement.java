// Time Complexity : Binary Search - O(logn)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    private int first(int[] nums, int low, int high, int target) // This menthod will find the first occurrence of the target element.
    {
        while(low<=high)// this will run till the low pointer is equal to or lesser than high pointer
        {
            int mid=low + (high-low)/2; // formula to calculate the mid, with integer overflow
            if(nums[mid]==target) // this statement will check, if the target element is equal to the mid element
            { 
                if(mid == low || nums[mid]>nums[mid-1]) //if the target is found, then we will check left element to the mid/target element is less than to the target element.
                {
                    return mid;// if yes, then return the first occurrence of the target.
                }else{ // if not, then we will update high to mid-1
                    high = mid-1;
                }
            }else if(nums[mid]>target){  // if the mid is greater than target, change hight to mid-1
                high= mid-1;
            }else{
                low=mid+1; //if the mid is less than target, change low to mid +1
            }
        }
        return -1;
    }
    private int last(int[] nums, int low, int high, int target)// This menthod will find the last occurrence of the target element.
    {
        while(low<=high) // this will run till the low pointer is equal to or lesser than high pointer
        {
            int mid=low + (high-low)/2; // formula to calculate the mid, with integer overflow
            if(nums[mid]==target)  // this statement will check, if the target element is equal to the mid element
            {
                if(mid == high || nums[mid]<nums[mid+1]) //if the target is found, then we will check right element to the mid/target element is greater than to the target element.
                {
                    return mid;// if yes, then return the first occurrence of the target.
                }else{
                    low = mid+1;// if not, then we will update high to mid-1
                }
            }else if(nums[mid]>target) // if the mid is greater than target, change hight to mid-1
            {
                high= mid-1;
            }else{ // if the mid is less than target, change low to mid+1
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = first(nums,0,nums.length-1,target);
        int right = last(nums,0,nums.length-1,target);
        return new int[]{left,right};
    }
}