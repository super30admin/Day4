// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
  if (nums.length === 0 || nums === null) {
    return -1;
  }

  var low = 0;
  var high = nums.length - 1;

  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    if (
      (mid === low || nums[mid] > nums[mid - 1]) &&
      (mid === high || nums[mid] > nums[mid + 1])
    ) {
      return mid;
    } else {
      if (nums[mid + 1] > nums[mid]) {
        //move right
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
};
