# Time Complexity: O(logn)
# Space Complexity: O(1)

# This code was passsed on LC: Not Fully, only some test cases
# Problems: I am getting List index out of range error

class Solution(object):
    def findPeakElement(self, nums):
        if len(nums)==1:
            return 0
        if len(nums)==2:
            return 0 if nums[0]>nums[1] else 1
        l = 0
        r = len(nums)-1
        
        while l<=r:
            mid = (l+r)//2
            if nums[mid-1]<nums[mid]>nums[mid+1]:
                return mid
            if nums[l]<nums[mid]:
                l = mid +1
            else:
                r = mid-1