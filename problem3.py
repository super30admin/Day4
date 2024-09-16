# Time complexity = o(logn)
# Space complexity = o(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        h = len(nums)-1
        
        
        while(l<=h):
            m = l+(h-l)/2
            if((m ==0 or nums[m]>nums[m-1]) 
               and (m == len(nums)-1 or nums[m]>nums[m+1])):
                return m
            elif(nums[m]<nums[m+1]):
                l = m+1
            else:
                h = m -1
                