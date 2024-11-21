//learning golang
//time complexity: O(logn)
//space complexity: O(1)

package main

func findPeakElement(nums []int) int {
	low, high := 0, len(nums)-1

	for low <= high {
		mid := low + (high-low)/2

		if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == len(nums)-1 || nums[mid] > nums[mid+1]) {
			return mid
		} else if mid > 0 && nums[mid-1] > nums[mid] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
