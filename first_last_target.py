"""
TC - O(Log(N))
SC - O(1)
Approach:
Find the first occurence of the target in the sorte array.
check mid element, if == target check if neighbour on left side is not target, if true, first occurence found.
if not true move left to find first occurence.
If mid element not target, and smaller than target, move right, else move left.
similarly search for last occurence.
Handle edge cases where mid could be first or last index of array, then surely it is first/last occurence.
If no occurence is found in first search target does not exist. This optimizes algo further.

"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarysearchfirst(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid] != nums[mid - 1]:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else: 
                    high = mid - 1
            return -1

        def binarysearchlast(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else: 
                    low = mid + 1
            return -1

        first = binarysearchfirst(nums, target, 0 , len(nums) - 1)
        if first == -1:
            return [-1, -1]
        last = binarysearchlast(nums, target, first , len(nums) - 1)
        
        return [first , last]