class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = self.binSearch(nums, target, True)
        r = self.binSearch(nums, target, False)
        return [l, r]
        
    # leftBias-> T/F, rightBias when F
    def binSearch(self, nums, target, leftBias):
        l, r = 0, len(nums) - 1
        i = -1
        while l <= r:
            m = (l + r) // 2 # m = (l + (r - l)) // 2 to avoid overflow
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                r = m - 1
            else:
                i = m
                if leftBias:
                    r = m - 1
                else:
                    l = m + 1
        return i

        # T: O(log n), S: O(1)