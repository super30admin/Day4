// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

var searchRange = function (nums, target) {
  let low = 0; // low = 0
  let high = nums.length - 1; // high = 5
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2); //mid = 2
    if (nums[mid] == target) {
      if (nums[mid + 1] && nums[mid + 1] == target) return [mid, mid + 1];
      else if (nums[mid - 1] && nums[mid - 1] == target) return [mid - 1, mid];
      else return [mid, mid];
    } else if (nums[low] <= target && target < nums[mid]) {
      // If target is between 1st half then high can be mid-1
      high = mid - 1;
    } else {
      // If target is between 2nd half then low can be mid+1
      low = mid + 1;
    }
  }
  return [-1, -1];
};
