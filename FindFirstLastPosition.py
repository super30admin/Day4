#The searchRange function finds the first and last positions of a target value in a list nums. It initializes first and last to -1. As it loops through nums, it updates first to the index of the first occurrence and last to the index of the last occurrence of the target. The function returns these indices, or [-1, -1] if the target isn't found. The time complexity is O(n), as it processes each element once, and the space complexity is O(1), using only a fixed amount of extra memory.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first, last = -1, -1
        for i in range(len(nums)):
            if nums[i] == target:
                if first == -1:
                    first = i
                last = i
        return [first, last]