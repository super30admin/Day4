#!/usr/bin/env python
# coding: utf-8

# In[1]:


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left , right =0 , len(nums)-1
        leftresult,rightresult = -1 , -1
        while left <= right :
            mid = left + (right-left)//2
            print(left,mid,right)
            if target == nums[mid]:
                leftresult = mid
                right = mid -1
            elif target < nums[mid]:
                right = mid-1
            else:
                left = mid+1
        left , right =0 , len(nums)-1
        while left <= right :
            mid = left + (right-left)//2
            print(left,mid,right)
            if target == nums[mid]:
                rightresult = mid
                left = mid +1
            elif target < nums[mid]:
                right = mid-1
            else:
                left = mid+1
        return [leftresult,rightresult]


# In[ ]:




