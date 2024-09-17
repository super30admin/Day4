
#implemented binary search method
# time complexity is o(logn)
# yes both the solutions worked on leetcode


class Solution(object):
    def findPeakElement(self, nums):
        l, r = 0, len(nums)-1
        while l < r:
            mid = l + (r-l)//2
            if nums[mid] > nums[mid+1]:
                r = mid
            else:
                l = mid + 1
        return l 
    
    
  #2nd method 

class Solution(object):
    
    def findPeakElement(self, nums):
        low= 0
        high=len(nums)-1
        
        while low<=high:
            mid=low+(high-low)//2
            if ((mid==low or nums[mid-1]<nums[mid]) and (mid==high or nums[mid]>nums[mid+1])):
                return mid
                
            elif nums[mid]<nums[mid+1]:
                low=mid+1
            else:
                high=mid-1
        return -1
                