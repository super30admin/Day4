#t.c = O(logn)
#s.c = O(1)

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def find_first(nums, target):
            low, high = 0, len(nums) - 1
            first = -1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] >= target:
                    if nums[mid] == target:
                        first = mid
                    high = mid - 1
                else:
                    low = mid + 1
            return first

        def find_last(nums, target):
            low, high = 0, len(nums) - 1
            last = -1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] <= target:
                    if nums[mid] == target:
                        last = mid
                    low = mid + 1
                else:
                    high = mid - 1
            return last

        first = find_first(nums, target)
        last = find_last(nums, target)
        
        return [first, last]
