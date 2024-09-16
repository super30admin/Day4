# Time Complexity : O(lg n) - findMin.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
# Your code here along with comments explaining your approach
# 1. First check if the given array is sorted and not rotated, by comparing the last and first element. If so, return the first element
# 2. Else, if array is rotated, use Binary Search. if mid found minimum element - must be less than its both left and right neighbors or if mid is 0 - right neighbor or if mid is 
#     last - left neighbor -> return mid
# 3. Otherwise, always move to the unsorted part - by comparing nums[mid] and nums[0], as minimum element always exist in unsorted part. 


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return None
        
        if nums[0] < nums[-1]:
            return nums[0]
        
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            
            elif nums[mid] < nums[0]:
                end = mid - 1
                
            else:
                start = mid + 1
                
                
        
