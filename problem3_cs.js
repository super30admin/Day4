// Time Complexity : O(lg n)
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//  wasn't handling edge cases like
//     1 element, 2 elements, peak is at [0...] or [...max-index]

// Approach:
// Do a binary search on nums
//   return mid if nums[mid-1] < nums[mid] > nums[mid+1]
//   else go right if nums[mid] < nums[mid+1]
//   else go left

//   notes: add edge cases where mid = 0 and mid = length-1, so skip mid-1 check and mid+1 check
var findPeakElement;

findPeakElement = function(nums) {
  var high, low, mid, ref;
  if (nums.length === 1) {
    return 0;
  }
  if (nums.length === 2) {
    if (nums[0] > nums[1]) {
      return 0;
    }
    return 1;
  }
  low = 0;
  high = nums.length - 1;
  while (low <= high) {
    mid = Math.floor(low + (high - low) / 2);
    if ((mid === 0 && nums[mid] > nums[mid + 1]) || (mid === nums.length - 1 && nums[mid - 1] < nums[mid]) || (nums[mid - 1] < (ref = nums[mid]) && ref > nums[mid + 1])) {
      return mid;
    } else if (nums[mid] < nums[mid + 1]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return -1;
};

//# sourceMappingURL=problem3_cs.js.map
