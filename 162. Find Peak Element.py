# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : It took me a lot of time develop get the intution that we can solve this using Binary Serach
#
# Problem Approach
# 1. Check if the first element is the peak or not
# 2. Check if the last element is peak or not
# 2. During each iteration we find mid and move to to the unsorted half of the array. This is followed until we enconter a situation where either (nums[mid] > nums[mid+1]) or (nums[mid] < nums[mid-1])
#      /\
#     /  \    
#    /    \  /\
#   /      \/  \
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        numslen = len(nums)
        
        if 1 == numslen: # if only one element then there is no peak
            return 0
        
        if nums[0] > nums[1]: # The first element is one of the peak (1 0 2 3 5 4)
            return 0
        
        if nums[numslen-1] > nums[numslen-2]: # The last element is one of the peak (0 2 3 5 4 6)
            return (numslen-1)
        
        
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end-start) // 2
            
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]: 
                return mid
            elif nums[mid] < nums[mid - 1]:  # mid lies on the right valley of the peak (0 2 5 4 3 6 1)
                end = mid-1
            else: # mid lies on the left valley of the peak (0 2 3 4 5 6 1)
                start = mid+1