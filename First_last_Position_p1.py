# // Time Complexity : O(logn) as it is using binary search.
# // Space Complexity : O(1) constant time as it is not using any auxilary memory.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : faced some difficulty while trying to pass some edge cases.


# // Your code here along with comments explaining your approach
# In this problem we perform binary search to calculate the first and last position of the target element.if the element is not found we #return -1.


class Solution(object):
    def firstpos(self,nums,target):
        low=0
        high=len(nums)-1
        if low>high:
            return -1
        while low<=high:
            mid=int(low+((high-low)/2))
            if nums[mid]<target:
                low=mid+1
            elif nums[mid]>target:
                high=mid-1
            else:
                if mid==0 or (nums[mid]>nums[mid-1]):
                    return mid
                elif mid!=0 and (nums[mid]==nums[mid-1]):
                    high=mid-1
        return -1
        
    def lastpos(self,nums,target):
        low=0
        high=len(nums)-1
        if low>high:
            return -1
        while low<=high:
            mid=int(low+((high-low)/2))
            if nums[mid]<target:
                low=mid+1
            elif nums[mid]>target:
                high=mid-1
            else:
                if mid==len(nums)-1 or (nums[mid]<nums[mid+1]):
                    return mid
                elif mid!=len(nums) and (nums[mid]==nums[mid+1]):
                    low=mid+1
        return -1
        
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)==0:
            return [-1,-1]
        first=self.firstpos(nums,target)
        last=self.lastpos(nums,target)
        return([first,last])
        