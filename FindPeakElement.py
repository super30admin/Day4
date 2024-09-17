class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        
        left = 0
        right = len(nums)-1
        
        if left == right :
            return left
        
        while left < right:
            
            mid = (left + right)//2
            
            if nums[mid] > nums[mid+1]:
                right = mid
            else:
                left = mid + 1
            
        return left
    
    