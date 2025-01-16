#time_complexity = lon(n)
#space_complexity = o(1)
#here we know that the least element always will be in unsorted array and I will find the unsorted array first and do check in that.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return
        if len(nums)==1:
            return nums[0]
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = low + (high - low)//2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid -1]) and (mid == len(nums)-1 or nums[mid] < nums[mid +1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid +1
            else:
                high = mid +1