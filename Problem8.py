def findFirstOccurrence(nums, target):
   
    left, right = 0, len(nums) - 1
   
    firstOccurrence = -1
   
    while left <= right:
       
        middle = left + (right - left) // 2
      
        if target == nums[middle]:
            firstOccurrence = middle
            right = middle - 1
        
        elif target < nums[middle]:
            right = middle - 1
        
        else:
            left = middle + 1
    return firstOccurrence


def findLastOccurrence(nums, target):
    
    left, right = 0, len(nums) - 1
   
    lastOccurrence = -1
   
    while left <= right:
    
        middle = left + (right - left) // 2
        
        if target == nums[middle]:
            lastOccurrence = middle
            left = middle + 1
        
        elif target < nums[middle]:
            right = middle - 1
       
        else:
            left = middle + 1
    return lastOccurrence


def searchRange(nums: List[int], target: int) -> List[int]:
    return [findFirstOccurrence(nums, target), findLastOccurrence(nums, target)]