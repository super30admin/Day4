from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = low + ((high - low) // 2)
            
            if nums[mid] == nums[high]:
                high -= 1
                
            elif nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1
                
        return nums[high]


obj = Solution()
print(obj.findMin([3,4,5,1,2]))
print(obj.findMin([4,5,6,7,0,1,2]))
print(obj.findMin([11,13,15,17]))


# Time Complexity : O(log(n))