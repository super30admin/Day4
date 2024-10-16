class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
      if len(nums) == 0 or nums == None:
        return -1 
      
      if len(nums) == 1:
        return 0
      
      left = 0
      right = len(nums) -1 


      while left <= right:
        mid= left + (right-left) //2 

        if nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]:
          return mid
        elif nums[mid] < nums[mid+1]:
          left = mid +1
        elif nums[mid] < nums[mid-1]:
          right = mid- 1

      return 1010

        