"""
Time Complexity : O(nlogn) where n is the number of elements in the array.
                  This complexity is the complexity for search algorithm
                  
Space Complexity : O(1), no auxillary data structure is use

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Peak element can be found if the element is greater than both of its neighbour.
2. Perform the binary search , if mid is peak then return mid
3. Otherwise, move to the element which is greater than the mid
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low+high) // 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
                    return mid
            elif mid > 0 and nums[mid-1] > nums[mid]:
                high = high - 1
            else:
                low = low + 1
        
        return -1
                    