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

## Solution:1 
## Time Complexity:O(logN) Space Complexity:O(1)
## We perform two binary searches one on the left side of the mid to find the first index if we can and other on the right half of the mid 
## for the right half we take the index returned from the first binary search as starting to prevent any repetitions to get the indexes.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = firstBinarySearch(nums, low, high, target);
        
        // If the target is not found, return [-1, -1].
        if (first == -1) {
            return new int[]{-1, -1};
        }
        
        int last = lastBinarySearch(nums, first, high, target);
        return new int[]{first, last};
    }

    private int firstBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int lastBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
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

## Solution 2:
## Time Complexity:O(logN) Space Complexity:O(1)
## We aim to find the unsorted array here because the minimum will always be present in the unsorted half in a sorted array. So through the binary
## search we find the low and high for unsorted keep on comparing the mid with their neighbours and get the minimum element.

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // If the array is already sorted (not rotated), return the first element.
        
        
        // Binary search to find the minimum element.
        while (low <= high) {
           
            if (nums[low] <= nums[high]) {
            return nums[low];
           }
            int mid = low + (high - low) / 2;
            // Check if mid is the minimum element.
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && 
                ((mid == nums.length - 1) || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            
            // Adjust search bounds based on sorted halves
            else if (nums[mid] >= nums[low]) { // Left half is sorted, search in right half.
                low = mid+1;
            }
             else { // Right half is sorted, search in left half.
                high = mid-1 ;
            }
        }
        
        // The minimum should have been found within the loop.
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

## Solution 3:
## Time Complexity:O(logN) and Space Complexity:O(1)
## Here peak can exist in both the side of mid if we perfom binary search but we try to go towards the higher slope in order to get the peak more easily,
## we handle the edge cases where peak can be at the first or the last index and solve the given problem.


class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;

        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(low==high)
           {
            return low;
           }
            if(((mid==0 || nums[mid]>nums[mid-1]) && (mid==(nums.length-1) || nums[mid]>nums[mid+1])))
            {
                return mid;
            }
            
            else{
               if((mid==0 && nums[mid]<nums[mid+1]) || nums[mid+1]>=nums[mid-1] ){
                low=mid+1;
               }
               else
               high=mid-1;
            }
        }
        return -1;
    }
}
