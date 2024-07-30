// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// time complexity:
// space complexity: 
var binarySearchFirst = function(nums, low, high, target){
    while(low <= high){
        let mid = Math.floor(low +(high - low)/2);
        if(nums[mid] === target){
          // if it is 1st index of target?
            if(mid === 0 || nums[mid] !== nums[mid-1]){
                return mid;
            }
            high = mid -1;
        }else if(nums[mid] > target){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }  
      return -1;
  }
  
// time complexity:
// space complexity: 
var binarySearchLast = function(nums, low, high, target){
    while(low <= high){
    let mid = Math.floor(low +(high - low)/2);
    if(nums[mid] === target){
        // if it is last index of target?
        if(mid === nums.length-1 || nums[mid] !== nums[mid+1]){
            return mid;
        }
        low = mid + 1;
    }else if(nums[mid] > target){
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}  
    return -1;
}

// time complexity:
// space complexity: 
var searchRange = function(nums, target) {
    let n = nums.length
    if(nums === null || n === 0) return [-1,-1];
    if(nums[0] > target || nums[n] < target) return [-1,-1];
    let first = binarySearchFirst(nums, 0, n-1, target);
    if(first == -1) return [-1,-1];
    let last = binarySearchLast(nums, first, n-1, target);
    return [first, last];
    
};