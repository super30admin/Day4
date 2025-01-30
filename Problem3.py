
# Time Complexity: O(log N)
# Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        l, r = 0, len(nums)-1

        while l < r:
            m = (l+r)//2

            if nums[m] > nums[m+1]:
                r = m           # Possible peak elemnt in leftside
            else:
                l = m + 1       # Possible peak elemnt in right side
        return l
        
