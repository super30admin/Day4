#Time Complexity: O(log(n)), since binary search is used.
# Space Complexity :O(1), as no extra space is used apart from some variables.
# This question is checked on leetcode 
class Solution:
    def findPeakElement(self, nums: list) -> int:
        
        start = 0
        end = len(nums) - 1
        
        while start < end: #applying binary search
            mid = int(start + (end - start)/2) # calculate the mid element
            
            if nums[mid] > nums[mid+1]: # move left if all the elements on the reight are decreasing
                end = mid
            else: # move right as the element nexgt to mid is increasing
                start = mid + 1
        return start