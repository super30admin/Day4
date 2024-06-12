# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
The concept is that if the element on the right is greater than the pivot we can move to the right and look
for the pivot in a greedy manner.
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            pivot = left + (right - left) // 2
            
            if pivot == len(nums) - 1 and nums[pivot] > nums[pivot - 1]:
                return pivot
            if pivot == 0 and nums[pivot] > nums[pivot + 1]:
                return pivot
            if pivot + 1 < len(nums) and pivot - 1 > -1:
                if nums[pivot - 1] < nums[pivot] > nums[pivot + 1]:
                    return pivot
            
            if nums[pivot] < nums[pivot + 1]:
                left = pivot + 1
            else:
                right = pivot - 1
        
        return -1