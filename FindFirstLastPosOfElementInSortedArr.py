class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        leftSide = self.binarySearch(nums, target, True)
        if leftSide == -1:
            return [-1,-1]
        
        rightSide = self.binarySearch(nums, target, False)
        
        return [leftSide, rightSide]
        
                
    def binarySearch(self, nums: List[int], target: int, isLeft: bool) -> int:
        
        left = 0
        right = len(nums)-1
        
        while left<=right:
            mid = (left+right)//2
            
            if target == nums[mid]:  
                if isLeft:
                    if mid == left or nums[mid-1] < target:
                        return mid
                    right = mid - 1
                else:
                    if mid == right or nums[mid+1] > target:
                        return mid
                    left = mid+1
                
                
            elif target > nums[mid]:
                left = mid +1
            elif target < nums[mid]:
                right = mid - 1
                
        return -1