"""
34. Find First and Last Position of Element in Sorted Array
Time Complexity - O(2log{n)) ~ O(logn)
Space Complexity - Constant Space O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.startpoint(nums,target)
        if (start == -1):
            return [-1,-1]
        return [start, self.endpoint(nums,target)]
    def startpoint(self,nums,target):
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != nums[mid]:
                    return mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        
    def endpoint(self,nums,target):
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != nums[mid]:
                    return mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        