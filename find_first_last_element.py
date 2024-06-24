
"""
Time Compexity: O(logmn)
Sace Complexity: O(1)
"""

class Solution:

    def BSF(self, nums, target, low, high):
        while(low <= high):
            mid = (low+high)//2

            if nums[mid] == target:
                if(mid == 0 or nums[mid] != nums[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def BSL(self, nums, target, low, high):
        while(low <= high):
            mid = (low+high)//2

            if nums[mid] == target:
                if(mid == len(nums) - 1 or nums[mid] != nums[mid+1]):
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:

        first = self.BSF(nums, target, 0, len(nums)-1)

        if first == -1:
            return [-1,-1]
        last = self.BSL(nums, target, first, len(nums)-1)

        return [first, last]
        
        