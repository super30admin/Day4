'''
LeetCode: https://leetcode.com/problems/find-peak-element/submissions/

Approach: 
1. Find the mid
2. If arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]; return the mid
3. Else perform binarySearch on lhs if arr[mid]<arr[mid-1]
4. Or perform binarySearch on rhs if arr[mid]<arr[mid+1]
5. Take care for border case i.e. we have [0] i.e. 1 element only

Time Complexity 0(logn)
'''

class Solution:
    
    def binarySearch(self,nums,low,high):
        
        if low > high:
            return -1
        
        # Get mid
        mid = (high-low)//2 + low
        
        # Perform check
        if (mid-1<0 or nums[mid]>nums[mid-1]) and (mid+1>=len(nums) or nums[mid]>nums[mid+1]):
            return mid
        
        elif mid-1>-1 and nums[mid-1]>nums[mid]:
            # binarySearch on the lhs
            result = self.binarySearch(nums,low,mid-1)
            
            if result == -1:
                result = self.binarySearch(nums,mid+1,high)
            
            return result
        
        elif mid+1<len(nums) and nums[mid+1]>nums[mid]:
            # binarySearch on the rhs
            result = self.binarySearch(nums,mid+1,high)
            
            if result == -1:
                result = self.binarySearch(nums,low,mid-1)
            
            return result
        
    def findPeakElement(self, nums) -> int:
        return self.binarySearch(nums,0,len(nums)-1)