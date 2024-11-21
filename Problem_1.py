# 34. Find First and Last Position of Element in Sorted Array

# Approach: Since the arrays is in sorted order, we can use Binary Search
    
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = []
        res.append(self.leftmost(nums,target))
        res.append(self.rightmost(nums,target))
        
        return res
        
    def leftmost(self, nums, target):
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low+(high-low)//2
            
            if nums[mid]==target:
                if mid==0 or nums[mid-1]!=target:
                    return mid
                high = mid-1
            elif nums[mid]>target:
                high =mid-1
            else:
                low = mid+1
        
        return -1
    
    def rightmost(self, nums, target):
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low+(high-low)//2
            
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]!=target:
                    return mid
                low = mid+1
            elif nums[mid]>target:
                high =mid-1
            else:
                low = mid+1
        
        return -1

# Time complexity: O(logN) + O(logN) = O(logN)
# Space complexity: O(1)