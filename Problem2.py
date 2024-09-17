#Problem 2:(https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
#Time Complexity-O(log n)
#Space Complexity-O(n)
#Test Cases passed on Leetcode 
#Binary Search Used
class Solution:
    def findMin(self, nums):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[low]<nums[high]:
                return nums[low]
            #finding the pivot -which would be minimum element if array was sorted 
            if (mid==low or nums[mid]<nums[mid-1]) and (mid==high or nums[mid]<nums[mid+1]):
                return nums[mid]
            #if nums[mid] is smaller than or equal to nums[low],we'll find the pivot on right half
            elif nums[low]<=nums[mid]:
                low=mid+1
            #else,we'll find the pivot on left half
            else:
                high=mid-1
        return -1

#validate code
obj=Solution()
nums=[3,4,5,1,2]
print("Array is:")
print(nums)
minElement=obj.findMin(nums)
print('Min Element in the array is: ')
print(minElement)
