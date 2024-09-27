// A peak element is an element that is greater than its neighbors.

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//------------------------------------------------------------

// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that nums[-1] = nums[n] = -∞.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 1 or 5 
// Explanation: Your function can return either index number 1 where the peak element is 2, 
//              or index number 5 where the peak element is 6.

let findPeakElement = function(nums) {
    if(nums.length === 1) return 0;
    if(nums[0] > nums[1]) return 0;
    if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
    let left = 0; right = nums.length-1;
    while(left <= right) {
        let mid = Math.floor(left + (right-left)/2);
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
        if(mid === 0 || nums[mid] > nums[mid-1]) left = mid+1;
        else right = mid-1;
    }
};