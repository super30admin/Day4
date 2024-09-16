# Did this code successfully run on Leetcode : YES

class Solution:
	def findMin(self, nums: List[int]) -> int:
		if len(nums) == 1:
			return nums[0]
		l = 0
		r = len(nums) - 1
		if nums[l] < nums[r]:
			return nums[l]
		while l <= r:
			m = (l+r)//2
			if nums[m] > nums[m+1]:
				return nums[m+1]
			if nums[m-1] > nums[m]:
				return nums[m]
			else:
				if nums[l] < nums[m]:
					l = m + 1
				else:
					r = m - 1