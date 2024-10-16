class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
      if len(nums) == 0 or nums == None:
        return [-1,-1]

      first = self.BinarySearch_first(nums, target)
      if first == -1:
        return [-1,-1]
      
      last = self.BinarySearch_last(nums, target)

      return [first, last]

    def BinarySearch_first(self, nums: List[int], target: int)-> int:
      left = 0
      right = len(nums) -1

      while left <= right:
        mid = left + (right - left) //2 

        if target == nums[mid]:
          # Check if it is the first Occurence
          if nums[mid -1] != target or mid == 0:
            return mid
          else:
            # move to the left
            right = mid -1

        elif nums[mid] > target:
          right = mid -1 
        else:
          left = mid + 1
      
      return -1  

    def BinarySearch_last(self, nums: List[int], target: int)-> int:
      left = 0
      right = len(nums) -1

      while left <= right:
        mid = left + (right - left) //2 

        if target == nums[mid]:
          # Check if it is the last Occurence
          if len(nums) -1 == mid or nums[mid+1] != target:
            return mid
          else:
            # move to the right
            left = mid +1

        elif nums[mid] > target:
          right = mid -1 
        else:
          left = mid + 1
      
      return -1        