# Search minimum in Rotated Sorted Array(https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Time complexity: O(log(n)); n=no of elements in array 
# Space complexity: O(1); 
# Did this code successfully run on Leetcode : Yes
# Approach: Binary search


class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums)-1
        mini = float('inf')
        
        
        while low <= high:
            mid = low + (high - low) // 2
            
            # For condition like 4,5,6,1,2,3
            if nums[low] < nums[high]:
                return nums[low]
            
            # Terminating condition. We found our minimum element
            if (mid == high or nums[mid] < nums[mid+1]) and (mid == low or nums[mid] < nums[mid-1]):
                return nums[mid]
                
            # Right part is not sorted. So, element would be towards right
            elif nums[low] <= nums[mid]:
                low = mid + 1
            
            # Left part is not sorted. So, element would be towards left
            else:
                high = mid - 1
                
        return -1
                
        