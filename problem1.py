# Find First and Last Position of Element in Sorted Array
# Time complexity: O(2logn) => O(logn)
# Space complexity: O(1)

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Going with two binary searches - 1 to find the starting point and the other ending point
        return [self.startingPoint(nums, target), self.endingPoint(nums, target)]
    
    def startingPoint(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) / 2
            if nums[mid] == target:
                if (mid == 0 or nums[mid - 1] != target): # includes check for first element
                    return mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def endingPoint(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) / 2
            if nums[mid] == target:
                if (mid == len(nums) - 1 or nums[mid + 1] != target): # includes check for last element
                    return mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1