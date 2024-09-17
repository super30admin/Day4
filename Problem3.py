#Problem 3
#Time Complexity-O(log n)
#Space Complexity-O(n)
#Test Cases passed on Leetcode 

class Solution:
	def findPeakElement(self, nums):
		low=0
		high=len(nums)-1
		while(low<=high):
			mid=low+(high-low)//2;
			# Compare middle element with its  
			# neighbours (if neighbours exist) 
			if ((mid == low or nums[mid - 1] < nums[mid]) and 
				(mid == high or nums[mid + 1] < nums[mid])): 
				return mid
				# If middle element is not peak and its left neighbour is greater  
				# than it, then left half must  
				# have a peak element 
			elif (mid > 0 and nums[mid - 1] > nums[mid]):
				high=mid-1
				# If middle element is not peak and its right neighbour is greater  
				# than it, then right half must  
				# have a peak element 
			else:
				low=mid+1
#To validate the solution
obj=Solution()
nums=[1,2,3,1]
print("Array is:")
print(nums)
peak=obj.findPeakElement(nums)
print('Peak Element\'s position(starting with 0) in the array is: ')
print(peak)
print('Peak element is:')
print(nums[peak])