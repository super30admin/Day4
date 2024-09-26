// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  let low = 0;
  let high = nums.length - 1;
  let currentMin = nums[low];
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    if (nums[low] <= nums[mid]) {
      // If 1st half of an array is sorted
      if (nums[low] <= currentMin) currentMin = nums[low];
      low = mid + 1;
    } else {
      //  2nd half of an array is sorted
      if (nums[mid] < currentMin) currentMin = nums[mid];
      high = mid - 1;
    }
  }
  return currentMin;
};
