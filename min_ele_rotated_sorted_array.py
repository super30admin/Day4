# time complexity = O(logn)
# space complexity = O(1)
# Use bianry search to find the min element
# check if entire range is sorted
# check if mid is the min/peak element
# look at the non sorted side and repeat the process


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            # check if entire range is sorted
            if nums[low] <= nums[high]:
                return nums[low]
            # check if mid is the min/peak element
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid-1]) and nums[mid] < nums[mid +1]:
                return nums[mid]
            if  nums[low] <= nums[mid]: # look at the non sorted side
                low = mid + 1
            else:
                high = mid - 1
