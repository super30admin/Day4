"""
Perform two binary searches one to find the first and another to find the last index.
Time complexity: O(logn)
Spce complexity: O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def searchFirst(l, h):
            n = len(nums)
            while l <=h:
                m = l + (h-l)//2
                if nums[m] >= target:
                    h = m-1
                elif nums[m] < target:
                    l = m+1
            return l if l<n and nums[l] == target else -1
        def searchLast(l, h):
            while l<=h:
                m = l + (h-l)//2
                if nums[m] <= target:
                    l = m+1
                elif nums[m] > target:
                    h = m-1
            return h 

        l, h = 0, len(nums)-1
        first = searchFirst(l, h)
        if first == -1:
            return [-1, -1]
        return [first, searchLast(first, h)]
        