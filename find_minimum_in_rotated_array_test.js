/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  let left = 0;
  let right = nums.length - 1;

  while (left < right) {
    let mid = Math.round(left + (right - left) / 2);
    let element = nums[mid];
    // If left half is sorted the move search range to right side
    // else left side.
    if (element < nums[right]) {
      // Move Left
      right = mid;
    } else {
      left = mid;
    }
  }
  return left;
};

test("Scenario #1: [5,6,7,1,2,3,4]", () => {
  expect(findMin([5, 6, 7, 1, 2, 3, 4])).toBe(3);
});
test("Scenario #2: [3, 1, 2]", () => {
  expect(findMin([3, 1, 2])).toBe(1);
});
test("Scenario #3: [1, 2, 3]", () => {
  expect(findMin([1, 2, 3])).toBe(0);
});
