 """
 Time Complexity :O(log n)
Space Complexity :O(1)
 Did this code successfully run on Leetcode : yes 
Any problem you faced while coding this : [2] test case was explicitly added when length is 1. else mid+1 and mid-1 went array out of bound

Finding Peak
"""

class Solution_peak:
    def findPeakElement(self, nums: List[int]) -> int:
        left=0
        right=len(nums)-1
        #if len is 1 ,only element is peak
        if len(nums)==1:
            return 0
        while left<=right:
            mid=left+(right-left)//2
            #if mid is less than mid+1 element , search in right side
            if nums[mid]<nums[mid+1]:
                left=mid+1
            #if mid is less than mid-1 element , search in left side
            elif nums[mid]<nums[mid-1]:
                right=mid-1
            #else mid element is peak
            else:
                return mid
