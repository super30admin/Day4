#Time Complexity: log(n)
#Space Complexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = []
        i, j = 0, len(nums)-1
        # normal binary search nothing fancy here
        while i <= j:
            mid = (i+j)//2
            if nums[mid] == target:
                # now we have found the target, just need to find start and end positions
                start, end = mid, mid
                while start > 0 and nums[start-1] == target:
                    start -= 1
                while end < len(nums)-1 and nums[end+1] == target:
                    end += 1
                return [start, end]
            elif nums[mid] > target:
                j = mid-1
            else:
                i = mid+1
        return [-1, -1]





