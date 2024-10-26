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

test("Scenario #1: [5, 7, 7, 8, 8, 10]", () => {
  let result = searchRange([5, 7, 7, 8, 8, 10], 8);
  let expected = [3, 4];
  expect(result).toStrictEqual(expected);
});
test("Scenario #2: [3, 3, 3]", () => {
  expect(searchRange([3, 3, 3], 3)).toStrictEqual([0, 2]);
});
