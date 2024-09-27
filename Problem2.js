// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//------------------------------------------------------------

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2]
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0

let findMin = function(nums) {
    if(!nums || nums.length === 0) return -1;
    if(nums.length === 1) return nums[0];
    
    let left = 0; right = nums.length-1;
    if(nums[0] < nums[right]) return nums[0];
    
    while(left <= right) {
        let mid = Math.floor(left + (right-left)/2);
        if(nums[mid+1] < nums[mid]) return nums[mid+1];
        else if(nums[mid-1] > nums[mid]) return nums[mid];
        
        if(nums[mid] > nums[0]) left = mid+1;
        else right = mid-1;
    } 
    return -1;
}