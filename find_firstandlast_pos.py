# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def findstrpt(self, nums, target):
        l = 0
        h = len(nums) - 1
        # perform Binary search for finding start pt
        while l <= h:
            m = l + (h-l) // 2
            if nums[m] == target:
                # if the elem to the left of m is not target then return the m index
                if m == 0 or nums[m -1] is not target: 
                    return m
                # update h to traverse left sub-arr to find the start pt of the target
                h = m - 1
            # traverse the right sub-arr to find the target
            elif nums[m] < target:
                l = m + 1
            # traverse the left sub-arr to find the target
            else:
                h = m - 1
        # otherwise return -1 if the target is not found
        return -1

    def findendpt(self, nums, target):
        l = 0
        h = len(nums) - 1
        # perform Binary search for finding start pt
        while l <= h:
            m = l + (h-l) // 2
            if nums[m] == target:
                # if the elem to the right of m is not target then return the m index
                if m == len(nums) - 1 or nums[m + 1] is not target:
                    return m
                # update l to traverse right sub-arr to find the end pt of the target
                l = m + 1
            # traverse the right sub-arr to find the target
            elif nums[m] < target:
                l = m + 1
            # traverse the left sub-arr to find the target
            else:
                h = m - 1
        # otherwise return -1 if the target is not found
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # call the functions to return the start and the end pt of the target in nums array
        start = self.findstrpt(nums, target)
        end = self.findendpt(nums, target)
        # return the start and the end positions
        return [start, end]