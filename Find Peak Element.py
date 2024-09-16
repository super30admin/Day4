# Time Complexity : O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0 
        r = len(nums)-1
        if len(nums)==1 :
            return 0
        while(l<=r):
            mid = l+(r-l)//2
            #check if middle is peak
            if(mid ==0 or(nums[mid]>nums[mid-1])) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif(mid == len(nums)-1 or nums[mid+1] >nums[mid]):
                l = mid+1
                
            else:
                r = mid-1
                
        return -1        