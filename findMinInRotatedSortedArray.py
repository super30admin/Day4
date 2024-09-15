'''
Leet Code: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Approach: 
1. Assume a target/pivot to be the last index i.e. "target = nums[high]"
2. If nums[mid] == target, return nums[mid]
3. Else perform binarySearch on lhs if target < nums[mid]. If we get -1, we will perform binarySearch on rhs
4. Else perform binarySearch in same range if target > nums[mid]. Here we will change target=nums[mid]

Time Complexity 0(logn)
'''
class Solution:
    
    def binarySearch(self,nums,low,high,target):
        
        if low > high:
            return -1
        
        # Find the mid
        mid = (high-low)//2 + low
        
        # Perform check
        if target == nums[mid]:
            return nums[mid]
        
        elif target < nums[mid]:
            # Go to lhs
            result =  self.binarySearch(nums,low,mid-1,target)
            
            if result == -1:
                return self.binarySearch(nums, mid+1, high, target)
            else:
                return result
            
        elif target > nums[mid]:
            return self.binarySearch(nums,low,mid,nums[mid])
        
    def findMin(self, nums) -> int:
        return self.binarySearch(nums,0,len(nums)-1,nums[len(nums)-1])