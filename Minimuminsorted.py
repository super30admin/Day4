#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l ,r = 0, len(nums)-1
        if nums == 0:
            return -1
        if len(nums)-1 == 0:
            return nums[0]
        if nums[r] > nums[0]:
            return nums[0]
        while l <= r:
            mid = l + ( r - l )//2
            if (nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]):
                return nums[mid+1]
            elif (nums[mid] < nums[mid+1] and nums[mid] < nums[mid-1]):
                return nums[mid]
            else:
                if nums[mid] > nums[r]:
                    l = mid+1
                elif nums[mid] <nums[r]:
                    r = mid-1
        return mid
                    

