class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        
        low, high = 0, len(nums)-1
        
        while low<=high:
            
            mid = (low+high)//2
            
            if (mid == len(nums)-1 or nums[mid]>nums[mid+1]) and (mid==0 or nums[mid]>nums[mid-1]):
                return mid
            
            else:
                if mid>0 and nums[mid-1]>nums[mid]:
                    high = mid-1
                elif nums[mid+1]>nums[mid]:
                    low = mid+1

# time complexity is log n as we are just running one binary search
#  Approach is to keep dividing the search space by 2 and if not mid then move towards the higher element.

#  Need to dig deeper as there is the weird issue with if you first go left...

                
