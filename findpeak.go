
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if no elements exist return -1

use normal binary search if mid is bigger than neighbours return mid
if right of mid is bigger move to that side
else move to left side

just try to go to the higher element side (left or right)
if not found return -1
*/package main

import "fmt"

func findPeakElement(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	low := 0
	high := len(nums) - 1
	for low <= high {
		mid := low + (high - low)/2
		if (low == mid || nums[mid] > nums[mid - 1]) && (high == mid || nums[mid] > nums[mid + 1]) {
			return mid
		} else if high == mid || nums[mid] < nums[mid + 1] {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func MainFindPeak() {
	nums := []int {1,2,3,1}
	fmt.Println(findPeakElement(nums)) //expected 2
}
