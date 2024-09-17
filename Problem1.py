#Time Complexity: O(logn)
#Space Complexity: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0:
            return [-1,-1]
        if nums[0] > target or nums[n-1] < target:
            return [-1,-1]
        first = self.searchRangeFirst(nums,target)
        if first == -1:
            return [-1,-1]
        last = self.searchRangeLast(nums,first,target)
        return [first,last]
    
    
    def searchRangeFirst(self,nums,target):
        low = 0
        high = len(nums)-1
        while low<= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1
    
    def searchRangeLast(self,nums,first,target):
        low = first
        high = len(nums)-1
        while low<= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == high or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low = mid+1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1
    