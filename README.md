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

// Time Complexity : O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : at first, found it difficult to handle duplicates in the condition checks  


// Your code here along with comments explaining your approach

class Solution {
    
    private int binarySearch1(int target, int arr[], int low, int high)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if((arr[mid] == target && mid-1 >=0 && arr[mid-1] != target) || (arr[mid] == target && mid -1 < 0) )
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return -1;
    }
    
    private int binarySearch2(int target, int arr[], int low, int high)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if((arr[mid] == target && (mid+1 <arr.length && arr[mid+1] != target)) || (arr[mid] == target && (mid + 1) >= arr.length))
            {
                return mid;
            }
            else if(arr[mid] <= target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        
        /*int discoveryIndex = binarySearch(target, nums, 0, nums.length -1);
        if (discoveryIndex == -1) return new int[] {-1,-1};
        // int i=discoveryIndex, j= discoveryIndex;
        // ----Linear search on left side and right side-------
        *while(i>=1 && nums[i-1]== nums[discoveryIndex] )
        {
            i--;
        }
        while(j< (nums.length-1) && nums[j+1]== nums[discoveryIndex])
        {
            j++;
        }
        
        return new int[]{i, j};
        */
        int firstOccurence = binarySearch1(target, nums, 0, nums.length -1);
        int lastOccurence = binarySearch2(target, nums, 0, nums.length -1);
        
        return new int[]{firstOccurence, lastOccurence};
    
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


