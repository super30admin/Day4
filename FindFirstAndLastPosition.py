# Time Complexity : logn + logn => O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #We will apply two binary search - one to find the first occurence and other to find the last occurence

        n = len(nums)
        low = 0 
        high = n-1
        first = -1
        last  = -1

        #binary search to get first occurence
        while low<=high:
            mid = low + (high - low) //2 
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid-1]:
                    first = mid
                    break
                else:
                    high = mid-1
            elif target > nums[mid]:
                low = mid+1
            else:
                high = mid-1

        if first == -1:
            return [-1,-1]
        
        #binary search to get the last occurence
        low = first
        high = n-1
        while low <= high:
            mid = low + (high - low) //2 
            if nums[mid] == target:
                if mid == n-1 or nums[mid] != nums[mid+1]:
                    last = mid
                    break
                else:
                    low = mid+1
            elif target > nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return [first,last]



        