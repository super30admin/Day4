# Time complexity: O(logn+logm)
# Space complexity: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarysearchfirst(nums, target, low, high):
            while low <= high:
                mid = low + (high-low)//2

                if nums[mid] == target:
                    if (mid==0 or nums[mid] != nums[mid-1]):
                        return mid
                    else:
                        high = mid-1
                elif nums[mid] > target:
                    high = mid -1
                else:
                    low = mid +1
            return -1
        
        def binarysearchlast(nums, target, low, high):
            while low <= high:
                mid = low + (high-low)//2

                if nums[mid] == target:
                    if (mid == len(nums)-1 or nums[mid] != nums[mid+1]):
                        return mid
                    else:
                        low = mid+1
                elif nums[mid] > target:
                    high = mid -1
                else:
                    low = mid +1
            return -1

        low = 0
        high = len(nums)-1
        first = binarysearchfirst(nums, target, low, high)
        if first == -1:
            return [-1,-1]
        last = binarysearchlast(nums, target, first, high)
        return [first, last]