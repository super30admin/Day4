class Solution:
	def findPeakElement(self, nums: List[int]) -> int:
		def binarySearch(nums, start, end):
			mid = (start + end)//2
			if start == end or nums[mid] > max(nums[mid-1], nums[mid+1]):
				return mid 
			if nums[mid+1] > nums[mid]:
				return binarySearch(nums, mid+1, end)
			else: 
				return binarySearch(nums, start, mid-1)
		return binarySearch(nums, 0, len(nums)-1)


#time complexity - O(logn) for binary search
#space complexity - O(1)
#all testcases passed
