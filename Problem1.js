// Given an array of integers nums sorted in ascending order, 
//find the starting and ending position of a given target value.

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//------------------------------------------------------------

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

var searchRange = function(nums, target) {
    if(!nums) return [-1, -1];
    if(nums.length === 1 && nums[0] === target) return [0,0]; 
    
    let left = 0; right = nums.length - 1;
    
    while(left <= right) {
       mid = Math.floor((left + right)/2);
       if(nums[mid] === target) {
           if(nums[mid] > nums[mid-1]) {
               left = mid;
               break;
           }
           //keep moving left
           else right = mid - 1;
       }
       else if(target > nums[mid]) left = mid + 1;
       else right = mid - 1;
    }
    if(nums[left] !== target) return [-1,-1];
    let startIndex = left;
    right = nums.length - 1;

    while(left <= right) {
        mid = Math.floor((left + right)/2);
        if(nums[mid] === target) {
           if(mid === nums.length -1 || nums[mid] < nums[mid+1]) {
               return [startIndex, mid];
           }
           //keep moving right
           else left = mid + 1;
        }
        else if(target > nums[mid]) left = mid + 1;
        else right = mid - 1;
    }
};