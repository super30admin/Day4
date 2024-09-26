class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
       
        
        while l <= h:
            mid = int((l+h)/2)
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                l = mid+1
            else:
                h = mid - 1 
        return -1