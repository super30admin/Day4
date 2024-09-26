# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. Check if the array is already sorted on not
# 2. During each iteration we find mid and move to to the unsorted half of the array. This is followed until we enconter a situation where either (nums[mid] > nums[mid+1]) or (nums[mid] < nums[mid-1])
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        
        start, end = 0, len(nums)-1
        
        if nums[start] < nums[end]: # Check if the array is aleady sorted, return nums[0] in this case
            return nums[start]
        
        while start <= end:
            mid = start + (end-start) // 2
            
            if nums[mid] > nums[mid+1]: # 4 5 6 7 0 1 2 (mid element is 7 and it is greater than 1)
                return nums[mid+1]
            elif nums[mid] < nums[mid-1]: # 5 6 7 0 1 2 3 (mid element is 0 and it is less than 7)
                return nums[mid]
            elif nums[mid] < nums[start]: # 6 7 8 0 1 2 3 4 5 (mid element is 1 and it is less than start index value -> move to the first half of the array)
                end = mid-1
            else:# 4 5 6 7 8 9 0 1 2 3 (mid element is 8 and it is greater than start index value -> move to the second half of the array)
                start  = mid+1