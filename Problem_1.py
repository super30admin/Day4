from typing import List

class Solution:
    
    def firstOccurence(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        first = -1
        
        while low <= high:
            mid = low + ((high - low)) // 2
            
            if nums[mid] > target:
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
                
            else:
                first = mid
                high = mid - 1
                
        return first
        
    def lastOccurence(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        last = -1
        
        while low <= high:
            mid = low + ((high - low)) // 2
            
            if nums[mid] > target:
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
                
            else:
                last = mid
                low = mid + 1
                
        return last
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        first = self.firstOccurence(nums, target)
        last = self.lastOccurence(nums, target)
        
        return [first, last]

obj = Solution()
print(obj.searchRange([5,7,7,8,8,10],8))
print(obj.searchRange([5,7,7,8,8,10],6))
print(obj.searchRange([],0))


# Time Complexity : O(log(n))
