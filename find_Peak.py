class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        start, end = 0, n - 1
        while start <= end:
            mid = (start+(end-start)//2)
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == n-1 or nums[mid] > nums[mid+1]):
                return mid
            if mid == 0 or nums[mid-1] < nums[mid]: 
                start = mid + 1
            else: 
                end = mid - 1
        return -1