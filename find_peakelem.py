# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        
        # perform Binary search
        while l <= h:
            m = l + (h-l) // 2
            # the elem at the m position is greater than the elem to left and right of it then return the position of the elem
            if (m == 0 or nums[m] > nums[m-1]) and (m == len(nums) - 1 or nums[m] > nums[m+1]):
                return m
            # if elem at m position is lesser than elem at m+1 position then traverse through the right sub-arr
            elif nums[m] < nums [m+1]:
                l = m + 1
            # if elem at m position is greater than elem at m-1 position then traverse through the left sub-arr
            else:
                h = m - 1