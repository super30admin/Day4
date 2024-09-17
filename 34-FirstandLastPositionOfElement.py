#Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
    def binarySearchFirst(self,nums: List[int], target):
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2

            if target == nums[mid]:

                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearchSecond(self,nums: List[int], target):
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2

            if target == nums[mid]:

                if mid == (len(nums) - 1) or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0 :
            return [-1,-1]
        if target < nums[0] or target > nums[len(nums)-1]:
            return [-1,-1]
        
        first = self.binarySearchFirst(nums, target)

        if first == -1:
            return [-1,-1]
        
        second = self.binarySearchSecond(nums, target)
        return [first,second]

    