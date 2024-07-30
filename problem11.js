// ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
// A peak element is an element that is greater than its neighbors.

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
// Note:

// Your solution should be in logarithmic complexity.
//  time complexity: O(log n)
//  space complexity: O(1)

var findPeakElement = function(nums) {
    let n = nums.length;
    let low = 0;
    let high = n - 1;
    while(low <= high){
        let mid = Math.floor(low + (high - low)/2);
        // Check if mid element is a peak
        if((mid === 0 || nums[mid] > nums[mid-1]) && (mid === n-1 || nums[mid] > nums[mid+1]) ){
            return mid;
        } 

        // If the element on the left is greater, then the peak is in the left part
        else if (mid > 0 && nums[mid-1] > nums[mid]){
            high = mid -1;
        }

        // If the element on the right is greater, then the peak is in the right part
        else {
            low = mid + 1;
        }
    }
    return -1;
};