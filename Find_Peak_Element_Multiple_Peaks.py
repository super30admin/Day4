# Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. The assumption in leetode is incorrect for cases like 1,2,1,3,5,6,8 (it gives 6 as the peak element)

# Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        # here we are not using equals as when low is same as high we have found the element
        while (low < high):
            mid = low + int((high - low) / 2)
            # base condition which means we have found the peak element
            if ((mid == 0) or (nums[mid] > nums[mid - 1])) and ((mid == len(nums) - 1) or (nums[mid] > nums[mid + 1])):
                return mid
            # this means we are at decreasing slope and peak should be in the left subarray
            elif (mid > 0) and (nums[mid] < nums[mid - 1]):
                high = mid - 1
            # else we are at increasing slope and peak should be in the right subarray
            else:
                low = mid +1
        return low