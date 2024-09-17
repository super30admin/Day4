# using binary search implementation
# time complexity is o(logn)
# yes both solution worked on leetcode

class Solution(object):
    def findMin(self, nums):
        if len(nums)==1: #case where only one element is present
            return nums[0]
        left=0
        right=len(nums)-1
        
        if nums[right]>nums[0]: # case where no rotation happens
            return nums[0]
        
        while right>=left:
            mid=left+(right-left)//2
            
            if nums[mid]>nums[mid+1]:# case where middle element is greater than next
                return nums[mid+1]
            if nums[mid-1]>nums[mid]: #case where element before is greater than middle element
                return nums[mid]
            if nums[mid]> nums[0]: # if middle element is greater than starting index then the lowest element is present in right half
                left=mid+1
            else:
                right=mid-1
    
#2nd solution

class Solution(object):
    def findMin(self, nums):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if ((mid==low or  nums[mid-1]>nums[mid]) and (mid==high or nums[mid+1] >nums[mid])):
                return nums[mid]
            elif nums[mid]>nums[high]:
                low=mid+1
            else:
                high=mid-1
        return -1