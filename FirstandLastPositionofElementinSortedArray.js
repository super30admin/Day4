// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  if (nums.length === 0 || nums === null) {
    return false;
  }

  var first = findOccurence1(nums, target);
  if (first === -1) {
    return [-1, -1];
  }
  console.log("here", first, second);
  var second = findOccurence2(nums, target);
  console.log("here", first, second);
  //   return [first, second];
};
// [5,7,7,8,8,10], target = 8
var findOccurence1 = function(nums, target) {
  var low = 0;
  var high = nums.length - 1;

  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    // console.log(nums[low], nums[high], nums[mid]);
    if (nums[mid] === target) {
      // Not the first occurence if previous item is target
      if (nums[mid - 1] !== target) {
        return mid;
      } else {
        high = mid - 1;
      }
    } else {
      // target is not expected to be found in left side if its greater & equal to
      if (target >= nums[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
};

var findOccurence2 = function(nums, target) {
  var low = 0;
  var high = nums.length - 1;
  console.log("hi");
  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    if (num[mid] === target) {
      if (nums[mid + 1] !== target) {
        return mid;
      } else {
        low = mid + 1;
      }
    } else {
      if (target > nums[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
};
console.log(findOccurence1([5, 7, 7, 8, 8, 10], 8));
