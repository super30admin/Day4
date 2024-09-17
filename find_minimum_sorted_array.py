# Time Complexity : O(log(n)) as we are using binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def findMin(self, nums) :
        if len(nums) == 0 and nums is None : # checking if list is empty
            return -1
        if len(nums) == 1 or nums[0] <= nums[len(nums) - 1]: # checking if list having single element
            return nums[0]
        low,high = 0,len(nums)-1
        while low <= high : # doing binary search
            if nums[low] <= nums[high]: #checking if the array is in sorted form
                return nums[low]
            mid = low +((high-low)//2)
            if nums[mid] <nums[mid-1] and nums[mid]<nums[mid+1] :
                return nums[mid] # Found minimum
            elif nums[low] <= nums[mid]: # binary search on right
                low = mid + 1
            else: # binary search on left 
                high = mid - 1
        return -1
