# Time Complexity: O(logn)
# Space Complexity : O(1)

# Explaination: Apply Binary search on the array to get the first element
#               Apply Second Binary Search to the last element

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def binarysearchFirst(target,nums):
            low = 0
            high = len(nums) - 1
            
            while(low <= high):
                mid = (low + high) / 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid -1] < nums[mid]:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
        def binarysearchLast(target,nums):
            low = 0
            high = len(nums) - 1 
            
            while(low <= high):
                mid = (low + high) / 2
                
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
                
        if not nums:
            return [-1,-1]
        
        if nums[0] > target and nums[-1] < target:
            return [-1,-1]
        
        start = binarysearchFirst(target,nums)
        end = binarysearchLast(target,nums)
        
        return [start,end]

