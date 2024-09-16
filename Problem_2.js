// Time Complexity : O(log(n)) - Binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

/*
Logic:Observe the array rotation
     mid
0,1,2,3,4,5,6,7
7,0,1,2,3,4,5,6
6,7,0,1,2,3,4,5
5,6,7,0,1,2,3,4
4,5,6,7,0,1,2,3
3,4,5,6,7,0,1,2
2,3,4,5,6,7,0,1
1,2,3,4,5,6,7,0

Observe that the smallest number is always in the unsorted array. Where one of the half is sorted.
The nums[mid] is the smallest when it is greater than previous and smaller than next number.
When nums[low]<=nums[high], the smallest number is the nums[low]
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
    // If the array does not exists or does not contain any element, return [-1,-1]
    if (nums === null || nums.length === 0)
        return -1;
    let low = 0;
    let high = nums.length - 1;
    while (low <= high) {
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        let mid = Math.floor(low + ((high - low) / 2));  // To prevent integer overflow
        // The nums[mid] is the smallest when it is greater than previous and smaller than next number.
        if ((mid === 0 || nums[mid - 1] > nums[mid]) && (mid === nums.length - 1 || nums[mid + 1] > nums[mid])) {
            return nums[mid];
        } else if (nums[low] <= nums[mid]) {
            // If left half is sorted, find element in the right half
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
};