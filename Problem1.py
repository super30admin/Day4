# 34. Find First and Last Position of Element in Sorted Array
# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Approach:
# 1. Use binary search to find the first position of the target element.
# 2. Use binary search to find the last position of the target element.
# 3. Return the first and last position of the target element.
# 4. If the target element is not found, return [-1,-1]. 
# 5. Keep an eye on the edge cases like single element or empty array, target not found, target not in the range of the array.

class Solution:
    def bsOnFirstPosition(self, nums, low, high, target):
        while low<=high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid == low or nums[mid] != nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def bsOnLastPosition(self, nums, low, high, target):
        while low<=high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid == high or nums[mid] != nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0 or nums[0] > target or nums[n-1] < target: return [-1,-1]
        first = self.bsOnFirstPosition(nums, 0, n-1, target)
        if(first == -1):
            return [-1,-1]
        second = self.bsOnLastPosition(nums, first, n-1, target)
        return [first,second]
        