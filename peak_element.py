# O(LOG(N)) TIME AND O(1) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left + right)//2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            if nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                right = mid - 1