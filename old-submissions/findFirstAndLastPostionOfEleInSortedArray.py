'''
Leet Code: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

Approach:
1. Perform binarySearch on the lhs and rhs seperately
2. When performing binarySearch on lhs:
    2.1. If mid == Target; adjust high = mid -1 and call binarySearch function
    2.2. Return indexLeft if its not -1
    2.3. Else return mid
3. When performing binarySearch on rhs:
    2.1. If mid == Target; adjust low = mid +1 and call binarySearch function
    2.1. Return indexRight if its not -1
    2.2. Else return mid

Time Complexity 
2 * 0(logn) 

Since we ignore constants it's 0(logn)
'''

class Solution:
    
    def binarySearchLeft(self,nums,low,high,target):
        
        if low>high:
            return -1
        
        # find mid
        mid = (high-low)//2+low
        
        # Perform check
        if nums[mid] == target:
            indexMid = mid
            indexLeft = self.binarySearchLeft(nums, low, mid-1, target)
            
            if indexLeft != -1:
                return indexLeft
            else:
                return mid
        
        elif target<nums[mid]:
            # binarySearch on the lhs
            return self.binarySearchLeft(nums,low,mid-1,target)
        
        elif target>nums[mid]:
            # binarySearch on the rhs
            return self.binarySearchLeft(nums,mid+1,high,target)
    
    def binarySearchRight(self,nums,low,high,target):
        
        if low>high:
            return -1
        
        # find mid
        mid = (high-low)//2+low
        
        # Perform check
        if nums[mid] == target:
            indexMid = mid
            indexRight = self.binarySearchRight(nums, mid+1, high, target)
            
            if indexRight != -1:
                return indexRight
            else:
                return mid
        
        elif target<nums[mid]:
            # binarySearch on the lhs
            return self.binarySearchRight(nums,low,mid-1,target)
        
        elif target>nums[mid]:
            # binarySearch on the rhs
            return self.binarySearchRight(nums,mid+1,high,target)
    
    def searchRange(self, nums, target: int) :
        firstIndex =  self.binarySearchLeft(nums,0,len(nums)-1,target)
        print('firstIndex is:\t',firstIndex)
        secondIndex =  self.binarySearchRight(nums,0,len(nums)-1,target)
        print('secondIndex is:\t',secondIndex)

sol = Solution()
sol.searchRange([1,2,3,3,3,3,4,5,9], 3)