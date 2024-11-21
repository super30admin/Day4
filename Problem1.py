class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binaryfirst(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if (nums[mid] == target):
                    if (mid == 0 or nums[mid - 1] < nums[mid]):
                        return mid
                    else:
                        high = mid - 1

                elif (nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        def binarysecond(nums, target, x):
            low = x
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if (nums[mid] == target):
                    if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                        return mid
                    else:
                        low = mid + 1
                elif (nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        if len(nums) == 0:
            return [-1, -1]
        if (target < nums[0] or target > nums[len(nums) - 1]):
            return [-1, -1]
        x = binaryfirst(nums, target)
        y = binarysecond(nums, target, x)
        return [x, y]










