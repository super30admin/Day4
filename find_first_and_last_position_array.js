/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  let firstIndex = binarySearch(nums, 0, nums.length - 1, target, -1);
  if (firstIndex == -1) {
    return [-1, -1];
  }
  let lastIndex = binarySearch(nums, firstIndex, nums.length - 1, target, 1);
  return [firstIndex, lastIndex];
};

var binarySearch = function (nums, left, right, target, direction) {
  while (left <= right) {
    let mid = Math.round(left + (right - left) / 2);
    if (nums[mid] == target) {
      let nextIndex = mid + direction;
      if (nextIndex >= 0 && nextIndex <= right && nums[nextIndex] == target) {
        if (nextIndex > mid) {
          left = nextIndex;
        } else if (nextIndex < mid) {
          right = nextIndex;
        } else {
          return mid;
        }
      } else {
        return mid;
      }
    } else if (nums[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return -1;
};

console.log(
  "Scenario #1: [5, 7, 7, 8, 8, 10] -> " + searchRange([5, 7, 7, 8, 8, 10], 8)
);
console.log("Scenario #2: [3, 3, 3] ->  " + searchRange([3, 3, 3], 3));
