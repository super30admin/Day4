# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Binary Search

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        s, e = 0, len(nums)-1
        while s<=e:
            mid = (s+e)//2
            midGreatThanLeft = mid==0 or nums[mid]>nums[mid-1]
            midGreatThanRight = mid == len(nums)-1 or nums[mid]>nums[mid+1]
            
            if midGreatThanLeft and midGreatThanRight:
                return mid
            
            # Go right if mid greater than Left
            if midGreatThanLeft: 
                s = mid+1
            else:
                e = mid-1
            
