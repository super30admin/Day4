# Time Complexity : O(log n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach in three sentences only

# in the rotated sorted array if the low <= high then the min is at low or when the mid is calculated 
# and the mid itself happens to be the min than their neighbors then that is the min
# otherwise the min will be in unsorted side of the mid in the array and we go that way by performing BS.



class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            if nums[low] <= nums[high]: # this means the array is not rotated or rotated n times 
                return nums[low] # or that part of the array has its min at low so return that
            mid = low + (high - low) // 2
            if nums[mid - 1] > nums[mid] and nums[mid] < nums[mid + 1]: # if mid itself is least than its neighbors
                return nums[mid] # then return mid
            elif nums[low] <= nums[mid]: # if the array is sorted on the left then go to right
                low = mid+1 # as the min will be in the unsorted side
            else:
                high = mid - 1 # otherwise go to left