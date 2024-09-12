// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  if (!nums || !nums.length) return [-1, -1];
  if (target < nums[0] || target > nums[nums.length - 1]) return [-1, -1];

  const first = searchFirstOccurr(nums, target);
  if (first === -1) return [-1, -1];
  const last = searchSecondOccurr(nums, target);

  return [first, last];
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchFirstOccurr = function (nums, target) {
  let low = 0;
  let high = nums.length - 1;
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    if (target === nums[mid]) {
      if (mid === 0 || nums[mid - 1] < nums[mid]) return mid;
      else {
        high = mid - 1;
      }
    } else if (target < nums[mid]) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchSecondOccurr = function (nums, target) {
  let low = 0;
  let high = nums.length - 1;
  while (low <= high) {
    let mid = Math.floor(low + (high - low) / 2);
    if (target === nums[mid]) {
      if (mid === nums.length - 1 || nums[mid + 1] > nums[mid]) return mid;
      else {
        low = mid + 1;
      }
    } else if (target < nums[mid]) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
};
