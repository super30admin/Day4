# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)==0:
            return [-1,-1]
        
        if (target<nums[0] or target>nums[-1]):
            return [-1,-1]
        
        firstOccurence = self.first(nums, target)
        if firstOccurence == -1:
            return [-1, -1]
        lastOccurence = self.last(nums, target)
        return [firstOccurence, lastOccurence]
    
    def first(self, nums, target):
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = low + (high-low)/2
            if nums[mid] == target:
                if(mid==low or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
            elif nums[mid]<target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def last(self, nums, target):
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = low + (high-low)/2
            if nums[mid]==target:
                if (mid==high or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif target<nums[mid]:
                high = mid -1
            else:
                low = mid + 1
        return -1
    
        
            