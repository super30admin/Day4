# Time Complexity : Add - O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
I used modified binary search to find a pivot element, element such that A[i] > A[i+1]

The code also works for a sorted array(just to account for 180 degree rotation), by returning first element if that case
occurs

'''

class Solution:
    
    def pivot_element(self, nums):
        
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + int((high - low)//2)
            if mid < high and nums[mid] > nums[mid+1]:
                return nums[mid+1]      
            elif mid > low and nums[mid-1] > nums[mid]:
                return nums[mid]         
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1                
        else:
            return nums[0]
        
        
    def findMin(self, nums):
        
        if nums == [] and len(nums) < 1:
            return
            
        pivot_element = self.pivot_element(nums)
        return pivot_element
        
        
                