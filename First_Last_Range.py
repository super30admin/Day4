class Solution(object):
    def searchRange(self, nums, target):
        """
        Solution:
        1. First find whether element is present of not. If not present return [-1, -1]
        2. If present, consider the index found(mid) to be the range [mid, mid] and store the chunk where you found mid
        3. update low index by binary searching from low to mid and update high index by binary searching from mid to high

        --- Passed all Leetcode test cases.
        """

        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid] == target):
                return [self.updateLow(nums, target, low, mid), self.updateHigh(nums, target, mid, high)]
            elif (nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1

        return [-1, -1]

    def updateHigh(self, nums, target, low, high):

        # O(logn) Time Complexity | O(1) Space Complexity
        higherId = low
        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid] == target):
                higherId = mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                continue
        return higherId

    def updateLow(self, nums, target, low, high):

        # O(logn) Time Complexity | O(1) Space Complexity
        leastId = high
        while (low <= high):
            mid = low + int((high - low) / 2)
            if nums[mid] == target:
                leastId = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                continue
        return leastId