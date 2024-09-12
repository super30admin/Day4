#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        
        l = 0
        h = len(nums)-1
        
        while(l <= h):
            mid = l + (h-l)//2
            print(l,h)
            if (mid ==0 or nums[mid]>nums[mid -1]) and (mid==len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            
            elif (nums[mid] < nums[mid +1]):
                l = mid +1
                
            else:
                h = mid -1
                
        return -1
                