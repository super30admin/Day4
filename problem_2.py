# Time Complexity : o(log n)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ 

# I have used binary search to find the minimum element in the rotated sorted array.
#  check the mid element with mid + 1 element and mid - 1 element to find the minimum element.
#  If the mid element is greater than mid + 1 element, then mid + 1 element is the minimum element.
#  If the mid element is greater than mid - 1 element, then mid element is the minimum element.
#  If the mid element is greater than the first element, then the minimum element is in the right side of the mid element.
#  If the mid element is less than the first element, then the minimum element is in the left side of the mid element.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        left = 0
        right = len(nums) - 1

        if nums[right] > nums[0]:
            return nums[0]



        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            
            if nums[mid-1] >nums[mid + 1]:
                return nums[mid]
            
            if nums[mid] > nums[0]:
                left = mid + 1
            
            else:
                right = mid - 1