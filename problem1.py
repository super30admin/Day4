# Time Comlexity: O(logn)
# Space Complexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def leftMost(nums, target):
            low, high = 0, len(nums)-1
            left = -1
            while(low<=high):
                mid = low + (high-low)//2
                if nums[mid] == target:
                    left = mid
                    high = mid-1
                elif target < nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
            return left

        def rightMost(nums, target):
            low, high = 0, len(nums)-1
            right = -1
            while(low<=high):
                mid = low + (high-low)//2
                if nums[mid] == target:
                    right = mid
                    low = mid+1
                elif target>nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
            return right

        return [leftMost(nums, target), rightMost(nums, target)]