#Time complexity: O(log n) because 1 bin search
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes, initially TLE for case [2,1]
# Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return None
        
        l,h = 0,len(nums)-1
        
        while l<=h:
            mid = l + (h-l)//2
            # checking if no rotation done, then already sorted initial element the smallest
            if nums[l]<= nums[h]:
                return nums[l]
            # similar condition as checking if mid is solution or not, checking if mid is the smallest
            if (mid ==0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[l]<= nums[mid]:
                l = mid + 1
            else:
                h = mid - 1
        
        return 123