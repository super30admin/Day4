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

// Time Complexity : O(log(n)) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

Problem 1 Solution: 

class Solution {
    
    private int binarySearchLeft(int[] nums,int target)
    {
        int low=0;  // the intial low
        int high= nums.length-1; // the last element- the initial high
         
        while(low<=high) 
        {
            int mid=low+(high-low)/2; //calculate the mid
            
            if(nums[mid]==target){ // if the mid elements is equal to the target 
            if(mid==0 || nums[mid]>nums[mid-1]) // then check if it is the first element in the array or not which is equal to the target
            {
                return mid; // if yes, then return that mid
            }
            else{
                high=mid-1; // else move left 
            }
            }
            else if(nums[mid] > target) // if mid element is greater than the target
            {
                high=mid-1; //move right
            }
            else{
                low=mid+1;  // else move left 
            } 
        }
        return -1; // return -1 if element not found
    }
    
    private int binarySearchRight(int[] nums, int target)
    {
        int low= binarySearchLeft(nums,target); // the initial low which is the first instance of the target
        int high= nums.length-1; // the initial high
         
        while(low<=high)
        {
            int mid=low+(high-low)/2; // calculate mid
    
            if(nums[mid]==target){ // if the mid element is equal to the target
            if(mid==nums.length-1 || nums[mid]<nums[mid+1]) // check if the found element is at the end of the array or is smaller than the immediate next element 
            {
                return mid; //if yes, return mid
            }
            else{
                low=mid+1; // else move right 
            }
            }
            else if(nums[mid] > target) //  if mid element is greater than the target
            {
                high=mid-1; //move left
            }
            else{
                low=mid+1; //else move right 
            } 
        }
        return -1; // return -1 if element not found
    }
    
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0) return new int[]{-1,-1}; // if the array is empty, return -1,-1
        
        if(nums[0]>target || nums[nums.length-1]<target) return new int[]{-1,-1}; // if the element is not present, return -1,-1
        
        int left= binarySearchLeft(nums,target); // binary search left to find the left index
        
        if(left==-1) return new int[]{-1,-1}; // if no element was found, return -1,-1
        
        int right= binarySearchRight(nums,target); //binary search right to find the right index
        
        return new int[]{left,right}; //return left and right
    }
    }

// Time Complexity : O(log(n)) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

     Problem 2:

     class Solution {
    public int findMin(int[] nums) {
       
        int low=0; //low index = 0 initially 
        int high= nums.length-1; // high at last index of array initially 
        
        
        while(low<= high){ // while low is less than equal to high 
        if(nums[low] <= nums[high]) //if the low element is less than the high element 
        { 
            return nums[low]; //return the low element 
        }
        
        int mid= low+(high-low)/2; // calculate the mid element 
        
        if((mid==0 || nums[mid]< nums[mid-1]) && (mid== nums.length-1 || nums[mid] < nums[mid+1]))
        {
            // if mid is the smallest element 
            return nums[mid]; // return the mid element 
        }
        else if(nums[low] <= nums[mid]) // if left side is sorted 
        {
            low= mid+1; // move to the right side since the smallest element lies in the unsorted side
        }
        else 
            high= mid-1; // else move to the left side 
        
        }
        
        return 29489284; // return some random number
    }
}


Problem 3: 

// Time Complexity : O(log(n)) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums== null || nums.length == 0) return -1; // if the array is empty return -1
        int low=0; // initial low
        int high= nums.length-1; // intial high 
        
        while(low<=high)
        {
            int mid= low+ (high-low)/2; //calculate mid
            
            if((mid==0 || nums[mid]> nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
        { //if mid is greater than it's left and right element 
            return mid; //return mid
        }
            
            else if(mid!=0 && nums[mid] < nums[mid-1]) //move to the greater element side
            {
                high=mid-1;
            }
            
            else
            {
                low= mid+1;
            }
        }
        return 48;
}
}