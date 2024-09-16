#Time Complexity : O(log N) beacuse of binary search
#Space Complexity : I am using the iterative version of binary serach, so It's O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Your code here along with comments explaining your approach


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Just find pivot
        
        start=0
        end=len(nums)-1
        
        if len(nums)==1:
            return nums[0]
        
        if nums[0]<nums[len(nums)-1]:
            return nums[0]
        
        while start<=end:
            mid=(start+end)//2
            if nums[mid]>nums[mid+1]:
                pivot=mid+1
                break
            elif nums[mid]<=nums[0]:    
                end=mid
            
            elif nums[mid]>=nums[0]:
                start=mid+1
        return nums[pivot]        