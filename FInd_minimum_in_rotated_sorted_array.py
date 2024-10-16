class Solution:
    def findMin(self, nums: List[int]) -> int:
      if nums == None or len(nums) == 0:
        return -1
      low = 0 
      high = len(nums)-1
      mid = low + (high -low)// 2
      while low < high:
        if nums[low] <= nums[high]:
          return nums[low]
        mid = low + (high-low) //2
        if (mid == 0 or (nums[mid] < nums[mid - 1])) and (mid == len(nums)-1 or (nums[mid] < nums[mid + 1])):
          return nums[mid]
        # move to the unsorted part of the array
        if nums[low] <= nums[mid]:
          low = mid+1
        else:
          high = mid-1
      return nums[high]