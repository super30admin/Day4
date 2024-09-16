#Time Complexity : O(log N) beacuse of binary search
#Space Complexity : I am using the iterative version of binary serach, so It's O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes, went through the discussion

#Your code here along with comments explaining your approach



class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1:
            return 0
        start=0
        end=len(nums)-1
        if len(nums)==2:
            if nums[0]>nums[1]:
                return 0
            else:
                return 1
    
        while start<=end:
        
            mid=(start+end)//2
            
            if (mid==0 and nums[mid]>nums[mid+1]) or (mid==len(nums)-1 and nums[mid]>nums[mid-1]) or (nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]):
                return mid
                
            elif nums[mid]<nums[mid-1]:
                end=mid-1
            
            elif nums[mid]<nums[mid+1]:
                start=mid+1
            