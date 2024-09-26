//learnings golang
//time complexity: O(log n)
//space complexity: O(1)

package main

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}

	low, high := 0, len(nums)-1

	first := binarySearchFirst(nums, target, low, high)

	if first == -1 {
		return []int{-1, -1}
	}

	last := binarySearchLast(nums, target, low, high)

	return []int{first, last}
}

func binarySearchFirst(nums []int, target int, low int, high int) int {
	for low <= high {
		mid := low + (high-low)/2

		if nums[mid] == target {
			if mid == 0 || nums[mid-1] < target {
				return mid
			} else {
				high = mid - 1
			}
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}

func binarySearchLast(nums []int, target, low, high int) int {
	for low <= high {
		mid := low + (high-low)/2

		if nums[mid] == target {
			if mid == len(nums)-1 || target < nums[mid+1] {
				return mid
			} else {
				low = mid + 1
			}
		} else if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
