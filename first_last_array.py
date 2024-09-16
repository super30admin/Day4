class Solution:
	def searchRange(self, nums: List[int], target: int) -> List[int]:
		left = 0
		right = len(nums)-1
		def first(nums, target, left, right):
			if left>right:
				return -1
			mid = (left+right)//2
			if (nums[mid]==target) and (mid==0 or target>nums[mid-1]):
				return mid
			elif target>nums[mid]:
				left = mid+1
				return first(nums, target, left, right)
			else:
				right = mid-1
				return first(nums, target, left, right)
			
		def second(nums, target, left, right):
			if left>right:
				return -1
			mid = (left+right)//2
			if (nums[mid]==target) and (mid == len(nums)-1 or target<nums[mid+1]):
				return mid
			elif target<nums[mid]:

				right = mid-1
				return second(nums, target, left, right)
			else:
				left = mid+1
				return second(nums, target, left, right)
			
		return [first(nums, target, left, right), second(nums, target, left, right)]

#time complexity - O(logn) for both first and second functions
#space complexity - O(1) as no auxillary data structures are used
#all test cases passed