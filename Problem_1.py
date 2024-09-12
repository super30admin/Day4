#LC 34
#Time Complexity : O(log N)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1
        foundIdx = -1 #Taking foundIdx like a flag
        nums.sort()
        while low <= high: # Applying Binary Search Algo in this block
            mid = (low + high)//2
            if target == nums[mid]:
                foundIdx=mid
                high=mid-1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        if foundIdx != -1:
            low = foundIdx
            high = len(nums)-1
            lastIdx = -1
            nums.sort()
            while low <= high:
                mid = (low + high)//2
                if target == nums[mid]:
                    lastIdx=mid
                    low=mid+1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return [foundIdx,lastIdx]
        else:
            return [-1,-1]
