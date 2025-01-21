#Problem-1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findBound(isFirst: bool) -> int:
            low, high, bound = 0, len(nums) - 1, -1

            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    bound = mid
                    if isFirst:
                        high = mid - 1  # Narrow to the left side
                    else:
                        low = mid + 1   # Narrow to the right side
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1

            return bound

        start = findBound(True)
        end = findBound(False)
        return [start, end]
#Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return
        if len(nums) == 1:
            return nums[0]
        low = 0
        high = len(nums) -1
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if nums[mid] < nums[mid-1] and nums[mid] < nums[mid+1]:
                    return nums[mid]
            if(nums[low] <= nums[mid]):
                    low = mid +1
            else:
                    high = mid -1
#Problem 3: (https://leetcode.com/problems/find-peak-element/)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums) -1
        while(low <= high):
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] > nums[mid -1]) and ( mid == len(nums) -1 or nums[mid] > nums[mid +1]):
                return mid
            elif mid == 0 or nums[mid] > nums[mid -1]:
                low = mid + 1
            else:
                high = mid - 1
        return 7899 


