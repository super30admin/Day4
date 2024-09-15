'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

#-------------  
# Explanation:
#-------------
#702. Search in a Sorted Array of Unknown Size
# - Run two iterations of binary search. One to find start and one to find end

#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - 2*logN. 1st logN to find the start. 2nd to find end
#------------------
# Space Complexity: 
#------------------
# O(1) - Constant space to store indices and values


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  84 ms (68.74 %ile)
# Space            :  15.4 MB (47.85 %ile)

from typing import List

class Solution:

    def binarySearchStart(self,nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + ( high - low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid

                high = mid-1

            elif nums[mid] > target:
                high = mid - 1

            else:
                low = mid + 1

        return -1

    def binarySearchEnd(self,nums, target, start=0):
        low = start
        high = len(nums) - 1

        while low <= high:
            mid = low + ( high - low)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid+1]:
                    return mid
                low = mid+1

            elif nums[mid] > target:
                high = mid - 1

            else:
                low = mid + 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1

        start = self.binarySearchStart(nums, target)
        if start == -1: return [-1, -1]

        if nums[low] > target or nums[high] < target: 
            return [-1, -1]

        end = self.binarySearchEnd(nums, target, start)

        return [start, end]