# Time Complexity: O(logn)
# Space Complexity: O(1)
# The code ran successfully on Leetcode
# Use Binary search for Peak Element
# Choose the direction that has higher element
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = low + (high-low)//2
            # Check the elements adjacent to mid element
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 998899