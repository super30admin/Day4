'''https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
'''
# Time Complexity : O(log(N)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# 4,5,1,2,3
# 2, 3, 4 ,5, 1
# 5, 1, 2, 3, 4 
class Solution:
    def findMin(self, nums: 'list[int]') -> int:
        low = 0 
        high = len(nums)-1
        while low <= high:
            # if array is in sorted order
            if nums[low] <= nums[high]:
                return nums[low]
            mid = int(low+(high-low)/2)
            # check if mid is min
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            # left half sorted, move to right
            if nums[mid] >= nums[low]: # for cond, check [2, 1]
                low = mid + 1
            # right half sorted, move to left
            else:
                high = mid - 1
                
        return None