// Time Complexity : O(2logN) which asymptomatically is O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
Algorithm : Binary Search

Perform Binary search twice to find start of the range and end.
**/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    
	//Base case
	if (nums === null || nums.length === 0) {
		return [-1, -1];
	}
    
	//Otherwise
	let start = findFirst(nums, target);
    
    //Base Case when it is not found
	if (start === -1) {
		return [-1, -1];
	}
	let end = findLast(nums, target);
    
	return [start, end];
};

//Function to find start of the range
var findFirst = function(nums, target) {
	let start = 0;
	let end = nums.length - 1;
	while (start + 1 < end) {
		let mid = Math.floor(start + (end - start) / 2);
		if (nums[mid] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}
    
	if (nums[start] === target) return start;
    
	if (nums[end] === target) return end;
    
	return -1;
};

//Function to find end of the range
var findLast = function(nums, target) {
	let start = 0;
	let end = nums.length - 1;
	while (start + 1 < end) {
		let mid = Math.floor(start + (end - start) / 2);
		if (nums[mid] > target) {
			end = mid;
		} else {
			start = mid;
		}
	}
    
	if (nums[end] === target) return end;
    
	if (nums[start] === target) return start;
    
	return -1;
};