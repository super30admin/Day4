# Time Complexity : Add - O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
I used modified binary search to find a pivot element, element such that A[i-1] < A[i] > A[i+1]

If an element A[i] > A[i+1], there will definitely be a peak element at a position <=i, Similarly if A[i]>A[i-1], then there
will a peak element at position >=i. Using this terminology I have used a Binary Search
'''

class Solution:
    def findPeakElement(self, nums):
        
        if nums == None or len(nums) < 1:
            return
            
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            
            mid = low + int((high - low)//2)
            
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return  mid
            
            
            elif mid < len(nums)-1 and nums[mid] > nums[mid+1]:
                high = mid-1
                
            else:
                low = mid + 1
                
                
                        