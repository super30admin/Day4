// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
  if (nums.length === 1) return 0;

  const lastIndex = nums.length - 1;

  let low = 0;
  let high = lastIndex;

  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);

    if (
      (mid == 0 || nums[mid] > nums[mid - 1]) &&
      (nums[mid] > nums[mid + 1] || mid == lastIndex)
    )
      return mid;
    else if (mid == 0 || nums[mid + 1] > nums[mid - 1]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
};
