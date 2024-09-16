# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution(object):
    # if array empty return -1
    # else binary search and if mid peak return mid
    # else continue search with the array that has a bigger neighbor
    def findPeakElement(self, nums):
        if len(nums) == 0:
            return -1
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = left + (right - left) / 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif mid > 0 and nums[mid-1] > nums[mid]:
                right = mid - 1
            else:
                left = mid + 1

        return -1

s = Solution()
nums = [2,6,1,6,7]
print s.findPeakElement(nums)

