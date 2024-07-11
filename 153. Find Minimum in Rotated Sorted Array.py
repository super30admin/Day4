#TC O(log n) SC O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        # if mid is smaller then mid - 1 and mid + 1 elements then it is the smallest element
        if nums == None or len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2 #prevent int overflow
            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 5458  #this will never be returned 
        