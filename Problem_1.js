// Time Complexity : O(log(n)) - Binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var getLeftOccurence = (nums, target) => {
    let low = 0;
    let n = nums.length;
    let high = n - 1;
    while (low <= high) {
        let mid = Math.floor(low + ((high - low) / 2)); // To prevent integer overflow
        if (nums[mid] === target) {
            // If target is found and it is the first element of the array or the int on the left is smaller,
            // the leftmost occurence is found
            if (mid === 0 || nums[mid - 1] < target) {
                return mid;
            }
            high = mid - 1;
        }
        else if (target < nums[mid]) {
            // If target is less than the mid value, search left half
            high = mid - 1;
        } else {
            // Serach right half
            low = mid + 1;
        }
    }
    return -1;
}
var getRightOccurence = (nums, target, lowerBound) => {
    let low = lowerBound;
    let n = nums.length;
    let high = n - 1;
    while (low <= high) {
        let mid = Math.floor(low + ((high - low) / 2)); // To prevent integer overflow

        if (nums[mid] === target) {
            // If target is found and it is the last element of the array or the int on the right is greater,
            // the rightmost occurence is found
            if (mid === n - 1 || nums[mid + 1] > target) {
                return mid;
            }
            low = mid + 1;
        }
        // If target is less than the mid value, search left half
        else if (target < nums[mid]) {
            high = mid - 1;
        } else {
            // Serach right half
            low = mid + 1;
        }
    }
    return -1;
}
var searchRange = function (nums, target) {
    // If the array does not exists or does not contain any element, return [-1,-1]
    if (nums === null || nums.length === 0) {
        return [-1, -1];
    }

    let left = (getLeftOccurence(nums, target));
    // If left occurence is not found, the element is not present in the array, return [-1,-1]
    if (left === -1) {
        return [-1, -1];
    }
    // If left index is found, the right index will be between right and array end. 
    // So find target in that range only
    let right = (getRightOccurence(nums, target, left));
    return [left, right];
};