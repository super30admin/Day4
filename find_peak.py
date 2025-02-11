#Time Complexity: O(log n)
#Space Complexity: O(1)


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1 

        while(low < high):
            mid = low +(high - low) // 2

            if nums[mid] > nums[mid + 1]:
                high = mid 
            else:
                low = mid + 1

        return low

        