#Time complexity: O(log n) because 1 bin search
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,h = 0,len(nums)-1
        # move search space towards bigger element closer to mid
        while l<=h:
            mid = l + (h-l)//2
            # check if mid is peak
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid!= 0 and nums[mid-1]> nums[mid]:
                h = mid -1
            else:
                l = mid + 1
        return 123
        