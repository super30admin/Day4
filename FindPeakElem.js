// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var findPeakElement = function (nums) {
    let low = 0, high = nums.length - 1;
    if (!nums || nums.length === 0) return -1;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if ((mid === 0 || nums[mid] > nums[mid - 1])
            && (mid === nums.length - 1 || nums[mid] > nums[mid + 1])) {
            return mid;
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return undefined;
};