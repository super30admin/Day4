#all test cases passed
#time_complexity: O(logn) for binary search
#space_complexity: O(1) no auxillary data structures used


class Solution:
	def findMin(self, nums: List[int]) -> int:
		if len(nums) == 1:
			return nums[0]
		if nums[0]<nums[-1]:
			return nums[0]
		low = 0
		high = len(nums) - 1
		while(low < high):
			mid = (low + high) // 2
			if mid == low:
				return min(nums[mid], nums[high])
			if nums[mid] > nums[low]:
				low = mid
			else:
				high = mid
		return nums[low]