class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left =0
        right = len(nums)-1
        while left<right:
            mid = left + int((right-left)/2)
            if nums[mid]>nums[mid+1]:
                right = mid
            else:
                left = mid+1
        return left
        
        
        #tc --> o(logn)
        #sc --> o(1)
