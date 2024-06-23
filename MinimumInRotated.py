# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
class Solution(object):
    def findMin(self, nums):
        # if completely sorted, meaning low val < high val, return low val that is minimum
        low = 0
        high = len(nums)-1
        while low < high:
            mid = low + (high-low) // 2
            #if nums[low] < nums[high]:
                #return nums[low]
            if nums[low] == nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid - 1]) and nums[mid] < nums[mid + 1]:
                return nums[mid]
            else:
                if nums[high] < nums[mid]: # left is sorted and hence min won't be here
                    low = mid + 1
                else:
                    high = mid - 1
        return nums[low]

