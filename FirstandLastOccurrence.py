# Time compliexity: O(log n)
# Space Complexity: O(1)
# Leetcode: Yes

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def firstPositionSearch(nums, target):
            low = 0
            high = len(nums) - 1
            
            if target == nums[low]:
                    return low

            while(low <= high):
                mid = (low + high) // 2

                if nums[mid] == target:
                    if nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                
                else:
                    if nums[mid] > target:
                        high = mid - 1
                    else:
                        low = mid + 1

            return -1
        
        def lastPositionSearch(nums, target):
            low = 0
            high = len(nums) - 1

            if (nums[high] == target):
                return high
            
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    if nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1
                else:
                    if (nums[mid] > target):
                        high = mid - 1
                    else:
                        low = mid + 1
            return -1

        if len(nums) == 0:
            return [-1, -1]

        n = len(nums) - 1
        if (target < nums[0] or target > nums[n]):
            return [-1, -1]

        first = firstPositionSearch(nums, target)
        if first == -1:
            return [-1,-1]
        
        last = lastPositionSearch(nums, target)

        return [first, last]