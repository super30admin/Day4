class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        : time complexity: O(logn)
        : space complexity: O(1)
        """
        low = 0
        high = len(nums)-1
        size = len(nums)
        while low <= high:
            mid = low + (high-low) /2
            if mid >0 and mid < size-1:
                if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                    return mid
                elif nums[mid-1]>nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            elif mid ==0:
                if nums[mid]> nums[1]:
                    return 0
                else:
                    return 1
            elif mid == size-1:
                if nums[mid]> nums[size-2]:
                    return size-1
                else:
                    return size-2
                
        
        