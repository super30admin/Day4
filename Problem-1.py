'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode:
    Approach: Ran two binary searches to find the low index and high index respectively. 
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        if not nums or len(nums) == 0: return[-1, -1]

        low = self.binarySearch(nums, 0, n - 1 , target, True)

        if low == -1: return [-1, -1]
        high = self.binarySearch(nums, low, n - 1, target, False)

        return [low, high]

    def binarySearch(self, nums, low, high, target, checkLeft):
        while low <= high:
            mid = low + (high - low) // 2
            if target > nums[mid]:
                low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                if checkLeft:
                    if mid == low or nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                else:
                    if mid == high or nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1

        return -1