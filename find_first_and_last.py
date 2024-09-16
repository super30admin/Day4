"""
We are going to perform 2 binary search operations. 
First to find the starting index of the target in the array
Second to find the ending index of target in the array
We will use a bool flag to use the same binarySearch code but tweak it for first and last
"""

class Solution(object):
    
    def binarySearch(self, nums, target, last):
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low)/2
            
            # mid is target
            if nums[mid] == target:
               
                # search for first occurrence
                if not last:
                    if mid == 0 or nums[mid] > nums[mid-1]:
                        return mid
                    else:
                        high = mid - 1
                
                # search for last occurrence
                else:
                    if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                        return mid
                    else:
                        low = mid + 1
                    
            elif nums[mid] > target:
                high = mid - 1
                
            else:
                low = mid + 1
                    
                
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        if len(nums) == 0 or nums is None or target not in nums:
            return [-1, -1]
        
        first = self.binarySearch(nums, target, False)
        last = self.binarySearch(nums, target, True)
            
                
        return [first, last]