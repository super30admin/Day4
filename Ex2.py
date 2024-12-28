class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            if nums[l] < nums[r]: # Array is already sorted
                res = min(res, nums[l])
                break

            # Bin Search
            m = (l + r) // 2
            res = min(res, nums[m])
            if nums[m] >= nums[l]: # Search R
                l = m + 1
            else: # Search L
                r = m - 1
            
        return res

    # T: O(log n), S: O(1)