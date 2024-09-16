# O(LOG(N)) TIME AND O(1) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = -1
        end = -1
        start = self.startBinary(nums,target)
        if start != -1:
            end = self.endBinary(nums,target)
        return [start,end]
    
    def startBinary(self,nums,target):
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] != target:
                    return mid
                else:
                    right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    def endBinary(self,nums,target):
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
                else:
                    left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1
    