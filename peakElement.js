// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Optimized approach
const findPeakElement = (nums) => {
  if (nums.length === 1) {
    return 0;
  }

  if (nums[0] > nums[1]) {
    return 0;
  }

  if (nums[nums.length - 1] > nums[nums.length - 2]) {
    return nums.length - 1;
  }

  let low = 0;
  let high = nums.length - 1;
  let mid;

  while (low <= high) {
    mid = Math.floor((low + high) / 2);
    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
      return mid;
    }

    if (nums[mid + 1] > nums[mid]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
};

console.log(findPeakElement([1, 2, 1, 3, 5, 6, 4]));

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Brute force approach:
const peakElement = (arr) => {
  console.log("this is arr:", arr);

  if (arr.length === 1) {
    return 0;
  }

  if (arr[0] > arr[1]) {
    return 0;
  }

  if (arr[arr.length - 1] > arr[arr.length - 2]) {
    return arr.length - 1;
  }

  for (let i = 1; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
      return i;
    }
  }
};

console.log(peakElement([1, 2, 3, 1]));
