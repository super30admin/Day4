// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not exactly, but it took me while to understand how to resolve this issue.

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
  let left = 0;
  let right = nums.length - 1;
  while (left < right) {
    let middle = Math.floor((left + right) / 2);
    if (nums[middle] > nums[middle + 1]) {
      right = middle;
    } else {
      left = middle + 1;
    }
  }
  return left;
};
