#Time Complexity: O(logn)
#Space Complexity: O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1
        while low <= high:
            if low == high:
                return low
            mid = (low+high)//2
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1