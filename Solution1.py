class Solution(object):
    def searchRange(self, nums, target):
        # algo:
        # 1. FIND IDX1: find if mid == target-> if yes then see if mid-1 is same as target
            # if yes then goto left and check binary way where is mid st mid-1 is NOT target
        # 2. FIND IDX2 in same way
        #3. if mid != target then move to find mid first in both 1 and 2
        low, high = 0, len(nums) - 1
        firstIdx, lastIdx = -1, -1
        while low <= high:
            mid = low + (high - low)/2
            if target == nums[mid]:
                if mid - 1 >=0 and nums[mid - 1] == target:
                    high = mid - 1
                else: 
                    firstIdx = mid
                    break
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        #print(firstIdx)
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low)/2
            if target == nums[mid]:
                if mid + 1 < len(nums) and nums[mid + 1] == target:
                    low = mid + 1
                else: 
                    lastIdx = mid
                    break
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return [firstIdx, lastIdx]