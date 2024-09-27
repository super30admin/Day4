#time complexity: O(logn)
#space complexity: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
		# left bound
        l, r = 0, len(nums) - 1
        left = -1
        while l <= r:
            mid = (l + r) //2
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            elif nums[mid] == target:
                left = mid
                r = mid - 1
        # right bound
        l, r = 0, len(nums) - 1       
        right = -1
        while l <= r:
            mid = (l + r) //2
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            elif nums[mid] == target:
                right = mid
                l = mid + 1
                
        return [left, right]