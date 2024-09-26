//learning golang

// time complexity: O(log n)
// space complexity: O(1)

package main

func findMin(nums []int) int {
	low, high := 0, len(nums)-1

	for low <= high {
		mid := low + (high-low)/2

		//check for sorted rage
		if nums[low] <= nums[high] {
			return nums[low]
		}

		//check if mid is minimum
		if (mid == 0 || nums[mid] < nums[mid-1]) && (mid == len(nums)-1 || nums[mid] < nums[mid+1]) {
			return nums[mid]
		} else if nums[low] <= nums[mid] { //left sorted
			//move righ
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}
