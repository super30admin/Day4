# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        
        # perform Binary Search
        while l <= h:
            m = l + (h-l)//2
            # check if the m ptr is at first position or elem at m-1 is greater than elem at m
            # and if the m ptr is at the last position or elem at m-1 is greater than elem at m
            if (m == 0 or nums[m] < nums[m - 1]) and (m == len(nums) - 1 or nums[m] < nums[m -1]):
                # return the elem at m position
                return nums[m]
            # if elem at m position is greater than elem at h position then traverse the right sub-arr
            elif nums[m] > nums[h]:
                l = m + 1
            # if elem at m position is lesser than elem at h position then traverse the left sub-arr
            else:
                h = m - 1