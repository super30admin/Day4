# time complexity O(logN)
# Space complexity O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        low, high = 0, len(nums) - 1 # l = 3, 5
        def find_left(nums, low, high):
            while low <= high:
                mid = low + (high-low) // 2  # mid = 4
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] != target:
                        return mid 
                    high = mid - 1 
                elif nums[mid] > target:
                    high = mid - 1 
                else:
                    low = mid + 1
            return -1

        def find_right(nums, low, high):
            while low <= high:
                mid = low + (high-low) // 2 
                if nums[mid] == target:
                    if mid == high or nums[mid+1] != target:
                        return mid 
                    low = mid + 1 
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        left = find_left(nums, low, high)
        right = find_right(nums, low, high)
        
        return [left, right]