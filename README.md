# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

// Time Complexity- O(logn)
//First finding the first occurance
//check the first exist if not return -1,-1
// find the last occurence
class Solution {
    public int[] searchRange(int[] nums, int target) {
       if(nums==null|| nums.length==0)
       {
        return new int[]{-1,-1};
       } 
       int first=binaryFirst(nums,target);
if(first==-1)
{
    return new int[]{-1,-1};
}
int second=binarySecond(nums,target);
return new int[]{first,second};
    }
    private int binaryFirst(int[] nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;//prevent integer overflow
            if(nums[mid]==target)
            {
                if(mid==0||nums[mid-1]!=target) return mid;
                high=mid-1;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    private int binarySecond(int[] nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==nums.length - 1 || nums[mid+1]!=target) return mid;
                low=mid+1;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return -1;
    }
}

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
//The smallest element will be lying in the unsorted part
// Time Complexity- O(logn)
class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
if((mid==0||nums[mid-1]>nums[mid])&& (mid==nums.length-1||nums[mid+1]>nums[mid])) return nums[mid];
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
// Time Complexity- O(logn)
//// if mid == peak ( case 2 )
// downward slope and search space left side ( case 1)
// upward slope and search space right side ( case 3 )
class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;// if mid == peak ( case 2 )
            else if(nums[mid]<nums[mid-1]) end=mid-1;// downward slope and search space left side ( case 1)
            else start=mid+1; // upward slope and search space right side ( case 3 )

        }
        return -1;
    }
}


