# 162. Find Peak Element

# Approach: We use Binary search to search elements faster 

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low+(high-low)//2
            
            if ((mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            elif (mid!=len(nums)-1) and (nums[mid+1]>nums[mid]):
                low=mid+1
            else:
                high = mid-1
        
        return -1

# Time Complexity: O(logN)
# Space Complexity: O(1)