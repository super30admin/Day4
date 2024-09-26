#!/usr/bin/env python
# coding: utf-8

# In[ ]:


"""
time complexity is O(logn)
space complexity is O(1)
implemented in leetcode.
got all the right thoughts to solve the problem. but i did not have confidence that I can do this sort of difficult 
problems even before starting the problem. I think i have to change my way of thinking. 
I SHOULD GET INTO PROBLEM WITH THE MINDSET OF "I CAN SOLVE IT"
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def binary_first(nums,target):
            low=0
            high=len(nums)-1
            while(low<=high):
                m=low+(high-low)//2
                if nums[m]==target:
                    if (((m==0) or (nums[m-1]<nums[m]))):
                        return m
                    else:
                        high=m-1
                        continue
                elif nums[m]>target:
                    high=m-1
                    continue
                else:
                    low=m+1
            return -1
        first=binary_first(nums,target)
        if first==-1:
            return [-1,-1]
        def binary_second(nums,target):
            low=first
            high=len(nums)-1
            while(low<=high):
                m=low+(high-low)//2
                if nums[m]==target:
                    if (((m==len(nums)-1) or (nums[m+1]>nums[m]))):
                        return m
                    else:
                        low=m+1
                        continue
                elif nums[m]>target:
                    high=m-1
                    continue
                else:
                    low=m+1
            return -1
        second=binary_second(nums,target)
        return [first,second]


# In[ ]:


"""
time complexity is O(logn)
space complexity is O(1)
implemented in leetcode.
got all the right thoughts to solve the problem. but i did not have confidence that I can do this sort of difficult 
problems even before starting the problem. I think i have to change my way of thinking. 
I SHOULD GET INTO PROBLEM WITH THE MINDSET OF "I CAN SOLVE IT"
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        m=0
        while(low<high):
            m=low+(high-low)//2
            if nums[m]>=nums[low] and nums[m]<=nums[high]:
                return nums[low]
            elif nums[m]<=nums[high]:
                high=m
                continue
            else:
                #in binary search problems we have to check if our changing
                #of low and high pointers results us in going to infinite loop.
                low=m+1
                continue


# In[ ]:


"""
time complexity is O(logn)
space complexity is O(1)
implemented in leetcode.
I should had got a thought that searching for an element takes O(logn) time complexity in only binary search.
then i should have checked different cases possible intelligently and found a pattern. INSTEAD I THOUGHT THAT THIS 
IS TOO DIFFICULT OF A PROBLEM FOR ME. I have to improve my self-confidence.
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            m=low+(high-low)//2
            if ((m==0) or (nums[m]>nums[m-1])) and ((m==len(nums)-1) or (nums[m]>nums[m+1])):
                return m
            elif nums[m]<nums[m+1]:
                low=m+1
                continue
            else:
                high=m-1
                continue


# In[5]:


#to improve things:
#manage my time
#even while thinking communicate my thoughts
#avoid silence as much as possible.


# In[ ]:





# In[ ]:





# In[ ]:




