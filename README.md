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



time complexity = logn
space complexity = O(1)



  class Solution {
    private int binarySearchFirst(int[] arr, int target, int low, int high){//binary search for start position
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] == target){
                if(mid == 0 || arr[mid] != arr[mid-1]){
                    return mid;
                } else{
                    high = mid - 1;

                }

            } else if(arr[mid] < target){
                //move right
                low = mid+1;
            } else{
                //move left
                high = mid -1;
            }
        }
        return -1;
    }
        private int binarySearchLast(int[] arr, int target, int low, int high){//Binary search for last position
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] == target){
                if(mid == arr.length-1 || arr[mid] != arr[mid+1]){
                    return mid;
                } else {
                    low = mid +1;
                }

            } else if(arr[mid] < target){
                //move right
                low = mid+1;
            } else{
                //move left
                high = mid -1;
            }
        }
	return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];//
        int first = binarySearchFirst(nums, target, 0, nums.length-1);
        if(first == -1){//if the number not present
            return new int[]{-1, -1};
        }
        int last = binarySearchLast(nums, target, first, nums.length-1);
        return new int[]{first, last};
         

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


time complexity = logn
space complexity = O(1)



class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length-1;
        
        while(low <= high){
            if(nums[low] <= nums[high]){//if array not rotated
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(mid !=0 && nums[mid] < nums[mid-1]){//if mid is the minimum
                return nums[mid];
            } else if(nums[low] <= nums[mid]){//
                low = mid + 1;//left sorted
            } else{
                high = mid - 1;
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

time complexity = logn
space complexity = O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0; int high = nums.length - 1;
        while(low <= high){
        int mid = low+(high-low)/2;
        if((mid == 0 || nums[mid] > nums[mid-1])//if mid is the peek
            &&
            (mid == nums.length-1 || nums[mid]>nums[mid+1])
            ){
                return mid;
                } else if(mid > 0 && nums[mid] < nums[mid-1]){
                    high =  mid - 1;//peek lies in left
                    } else{
                        low = mid+1;//peek may lie in right
                    }
    }
    
    return -1;
    }
}

