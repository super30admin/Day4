// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


var searchRange = function (nums, target) {
    if (!nums || nums.length === 0) return [-1, -1];
    if (nums[0] > target || nums[nums.length - 1] < target) return [-1, -1];
    let first = binarySearchLeft(nums, target);
    if (first == -1) return [-1, -1];
    let last = binarySearchRight(nums, target);
    return [first, last];
};

var binarySearchLeft = function (nums, target) {
    let low = 0, high = nums.length - 1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (nums[mid] === target) {
            if (mid === 0 || nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                high = mid - 1;
            }
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

    }
    return -1
}

var binarySearchRight = function (nums, target) {
    let low = 0, high = nums.length - 1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (nums[mid] === target) {
            if (mid === nums.length - 1 || nums[mid] < nums[mid + 1]) {
                return mid;
            } else {
                low = mid + 1;
            }
        } else if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

    }
    return -1;
}



// var searchRange = function (nums, target) {
//     return [find(nums, target), find(nums, target, false)]
// };

// var find = function (nums, target, findElem = true) {
//     let low = 0, high = nums.length - 1;

//     while (low <= high) {
//         const mid = Math.floor((low + high) / 2);
//         if (nums[mid] < target) {
//             low = mid + 1;
//         } else if (nums[mid] > target) {
//             high = mid - 1;
//         } else {
//             //When target == mid,
//             //checking its left and right elem
//             if (findElem) {
//                 if (nums[mid - 1] == target) {
//                     high = mid - 1
//                 } else return mid;

//             } else {
//                 if (nums[mid + 1] == target) {
//                     low = mid + 1;
//                 } else return mid;

//             }
//         }
//     }

//     return -1;
// }