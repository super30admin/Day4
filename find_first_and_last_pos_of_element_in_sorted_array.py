class Solution:   #BRUTE FORCE - Time complexity - O(n)
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result = []
        if not nums:
            return [-1,-1]
        for i in range(len(nums)):
            if nums[i] == target:
                result.append(i)
        if result:
            return [result[0], result[-1]]
        else:
            return [-1,-1]
