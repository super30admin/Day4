# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        
        low, high = 0, len(nums) - 1

        first = self.binarySearch(nums, low, high, target, True)
        last = self.binarySearch(nums, low, high, target, False)

        return [first, last]

    def binarySearch(self, nums, low, high, target, first):
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if first:
                    if mid == 0 or nums[mid-1] < nums[mid]:
                        return mid
                    else:
                        high = mid - 1
                else:
                    if mid == len(nums) - 1 or nums[mid] < nums[mid+1]:
                        return mid
                    else:
                        low = mid + 1
            
            elif nums[mid] < target:
                low = mid + 1
            
            else:
                high = mid - 1
        
        return -1