// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

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
/**
 * @param {number[]} nums
 * @return {number}
 */

//  time complexity: O(log n)
//  space complexity: O(1)
var findMin = function(nums) {
    let n = nums.length;
    let low = 0;
    let high = n-1;
    while(low <= high) {
        // If the subarray is already sorted, return the minimum element
        if (nums[low] <= nums[high]){
            return nums[low];
        }

        let mid = Math.floor(low + (high - low)/2);

        // Check if the mid element is the minimum
        if(
            (mid === 0 ||nums[mid] < nums[mid-1]) 
            && (nums[mid] < nums[mid+1])
        ){
            return nums[mid]
        }  // Decide which part to search next
        else if(nums[low] <= nums[mid]){
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return 1818; // Placeholder, will never be reached if input is valid
    
};