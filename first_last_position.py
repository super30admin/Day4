# Did this code successfully run on Leetcode : YES

class Solution:
	def searchRange(self, nums: List[int], target: int) -> List[int]:
		
		def start_search(nums):
			l, r = 0, len(nums)-1
			start = -1
			while l <= r:
				m = (l+r)//2
				if nums[m] == target:
					if m == 0 or nums[m-1] != target:
						start = m
						return start
					else:
						r = m
				elif nums[m] > target:
					r = m - 1
				else:
					l = m + 1
			return start
		
		def end_search(nums):
			l, r = 0, len(nums)-1
			end = -1
			while l <= r:
				m = (l+r)//2
				if nums[m] == target:
					if m == (len(nums)-1) or nums[m+1] != target:
						end = m
						return end
					else:
						l = m + 1
				elif nums[m] > target:
					r = m - 1
				else:
					l = m + 1
			return end
		
		if nums:
			return [start_search(nums), end_search(nums)]
		return [-1, -1]