# Search in roatated array
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed the solution from class
# // Your code here along with comments explaining your approach

# move towards the greater element always
class Solution:
    def findPeakElement(self, nums):
        if(nums == None or len(nums)==0):
            return 1
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            #if mid is peak
            if((mid == 0 or nums[mid] > nums[mid-1]) and 
               (mid == len(nums)-1 or nums[mid] > nums[mid+1])):
               return mid
            elif(mid != 0 and nums[mid] < nums[mid-1]):
               high = mid - 1
            else:
               low = mid + 1
        return
               
                
                
        