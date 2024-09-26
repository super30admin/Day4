# Time Complexity : O(logN)
# Space Complexity : O (1) as no extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took me a little while to understand the logic

class Problem1:

    def findBound(self, nums, target: int, isFirst: bool) -> bool:
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if target == nums[mid]:
                if isFirst:
                    # we are at the start if lo index == mid index
                    # or if the target element is greater than nums[mid -1]
                    if lo == mid or target > nums[mid - 1]: 
                        return mid
                    # if not at start, check left half
                    hi = mid - 1
                else:
                    # we are at the end if mid == hi
                    # or if the target element is less than mid + 1
                    if hi == mid or target < nums[mid + 1]:
                        return mid
                    # if not at end, check right half
                    lo = mid + 1
            elif target < nums[mid]:
                hi = mid - 1
            else:
                lo = mid + 1
        return -1
    
    def searchRange(self, nums, target: int):
            
            low = self.findBound(nums, target, True)
            if low == -1:
                return [-1, -1]
            high = self.findBound(nums, target, False)
            return [low, high]


# nums = [5,7,7,8,8,10]
# target = 8
# nums = [5,7,7,8,8,10]
# target = 6

nums = [] 
target = 0
obj = Problem1()
print(obj.searchRange(nums, target))
                