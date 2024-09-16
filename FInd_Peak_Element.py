#time:O(n)
#space:O(1)
#LeetCode: no, giving runtime error
#Problem Faced:how to apply binary search
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #doing a brute force 
        if len(nums)==0: return 0
        low=0
        high=len(nums)-1
        for i in range(1,len(nums)-1):
            if nums[i]>nums[i-1] and nums[i]>nums[i+1]:
                return i
        if nums[low]>nums[low+1]:
            return 0
        if nums[high]>nums[high-1]:
            return len(nums-1)
        return -1        
        