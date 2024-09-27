// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  if (nums === null || nums.length === 0) {
    return -1;
  }
  var low = 0;
  var high = nums.length - 1;
  var min = nums[low];

  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    //Traverse left side
    if (nums[low] <= nums[mid]) {
      if (nums[low] < min) {
        min = nums[low];
      }
      low = mid + 1;
    } else {
      if (nums[mid] < min) {
        min = nums[mid];
      }
      high = mid - 1;
    }
  }
  return min;
};
