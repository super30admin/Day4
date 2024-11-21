"""
Time complexity: O(logN) = N is the number of elements
Space complexity:O(1) - No extra space used

Explaination:
1.  base case - the peak element will be greater than its neighbours
2. move towards the side where there is maximum element

"""


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
