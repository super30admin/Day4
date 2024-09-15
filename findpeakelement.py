class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1

    
        while l <= r:
            mid = (l+r)//2
            midVal = nums[mid]
            if mid+1 == len(nums):
                return mid
            if midVal > nums[mid+1] and midVal> nums[mid-1]:
                return mid
            elif midVal > nums[mid+1] and midVal < nums[mid-1]:
                r = mid -1
            else: 
                l = mid + 1
                
        return -1