# Time Complexity : O(log n)
# Space Complexity :O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if the lenght of list is 0 then return -1
        if nums is None or len(nums) == 0:
            return -1
        # if the length of list is 1 then return 0 because thats the only element present in the list
        if len(nums) == 1:
            return 0

        l = 0
        h = len(nums) - 1

        # do a binary search
        while (l <= h):
            mid = (l + h) // 2
            # if the index next to mid does not exist or the value in the next index is greater than the mid + index previous to mid does not exist or is smaller then that is the answer
            if (mid + 1 > len(nums) - 1 or nums[mid] > nums[mid + 1]) and (mid - 1 < 0 or nums[mid] > nums[mid - 1]):
                return mid
            # if there is an increasing trend from mid then update the low pointer else update the high pointer
            if mid + 1 < len(nums) and nums[mid] < nums[mid + 1]:
                l = mid + 1
            else:
                h = mid - 1
        return -1
