
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if no elements exist return -1

start with low and high as 0, length-1
till low <= high
if array is sorted return lowest element directly
if mid point is the highest in neighbours return mid element
else based on mid the non sorted side will have the smallest element (as pivot point will be lowest)
move high or low to the non sorted side of mid
*/
package main

import "fmt"

func findMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	low := 0
	high := len(nums) - 1
	for low <= high {
		if nums[low] < nums[high] {
			return nums[low]
		}
		mid := low + (high - low)/2
		if (low == mid || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid] < nums[mid + 1]) {
			return nums[mid]
		} else if nums[low] > nums[mid] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}

func MainFindMin() {
	nums := []int {3,4,5,1,2}
	fmt.Println(findMin(nums)) //expected 1
}