# Time complexity: O(logn)
# Space complexity: O(1)
#  Did it run on leetcode: yes

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end = len(nums) - 1
        while start < end:
            mid = (start + end)//2
            if nums[end] < nums[mid]:
                start = mid+1
            else:
                end = mid
                
        return nums[start]