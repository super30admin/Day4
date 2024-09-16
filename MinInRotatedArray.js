// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


var findMin = function (nums) {
    let low = 0, high = nums.length - 1;
    if (nums[low] <= nums[high]) return nums[low];
    while (low <= high) {
        if (nums[low] <= nums[high]) return nums[low];
        let mid = Math.floor((low + high) / 2);
        if ((mid === 0 || nums[mid] < nums[mid - 1]) &&
            (mid === nums.length - 1 || nums[mid] < nums[mid + 1])) {
            return nums[mid];
        } else if (nums[low] <= nums[mid]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
};





// var findMin = function (nums) {
//     let low = 0, high = nums.length - 1;

//     while (low < high) {
//         const mid = Math.floor((low + high) / 2);
//         if (nums[mid] > nums[high]) {
//             low = mid + 1;
//         } else {
//             high = mid;
//         }
//     }
//     return nums[low];
// };