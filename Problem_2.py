# Search in roatated array
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed the solution from class
# // Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums):
        if (nums == None or len(nums) == 0):
            return -1
        low =0
        high = len(nums)-1
        while(low <= high):
            if(nums[low] < nums[high]): return nums[low]
            mid = low + (high - low)//2
            if((mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            elif (nums[low] <= nums[mid]):#if left sorted
                low = mid + 1
            else:
                high = mid -1
        return
                
        