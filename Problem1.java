/*
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
*/

/*Optimised and Efficient Approach-Binary Search*/
// Time Complexity : O(logN) 
// Space Complexity : O(1)(constant sized array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. it was difficult in understanding how left and right indexes are traversed based on logic. but now it makes sense

// Your code here along with comments explaining your approach
// Approach-we will consider left and right indexes by implementing binary search on both sides
//base case: if mid element == target, travserse left or right side else, initialise low and high pointers to left and right side if target is less or more than mid
//for left side, we will consider if mid element > prev left element, return mid else, we will bring high pointer to left side
//for right side, we will consider if mid element < prev right element, return mid else, we will bring low pointer to right side

class Solution {
    private int binarySearchLeft(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //base case
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchRight(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //base case
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target){
        //edge case
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        return new int[] {left, right};
    }
}


/*Brute Force Approach-Linear Scan
// Time Complexity : O(N) (in actual, its 2N but we higher order and not constants)
// Space Complexity : O(1)(constant sized array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//brute force approach-1)Linear Scan: first linear scan(traverse) from left, break of target is found else return-1,-1
//secondly, traverse scan from right and do the same and return a list of indices for left and rightmost

class Solution{
    public int[] searchRange(int[] nums, int target){
        int[] targetRange = {-1,-1};
    
        //1.finding index of leftmost appearance of target
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                targetRange[0] = i;
                break;
            }
        }
        //2.returning -1,-1 if we don't find left index
        if(targetRange[0] == -1){
            return targetRange;
        }
        //3. find rightmost index of target
        for(int j = nums.length; j >= 0; j--){
            if(nums[j] == target){
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
}
*/
