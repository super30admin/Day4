// Time Complexity : 2*O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Check for the target element's left most position such that 
   target is greater than its left index element
2. Similarly for right most target index do the binary search such that 
   target is less than element at right most index element.
3. If not found retun [-1 ,-1]
4. we can further opmize the binary search for right most element by 
   starting from left most index instaed of zero
'''

class Solution:
    def right_search(self,nums,target):
        start =0
        end =len(nums)-1
    
        while start<=end:
            
            mid=start+(end-start)//2
            
            
            if (mid==0 and nums[mid]==target) or (nums[mid]==target and nums[mid]>nums[mid-1]) :
                return mid
            else:
                if target<= nums[mid]:
                    end=mid-1
                else:
                    start=mid+1
        return -1
                    
    def left_search(self,nums,target,start_pos):
        
        if start_pos ==-1:
            start =0
        else:
            start=start_pos
            
        end =len(nums)-1
    
        while start<=end:
            
            mid=start+(end-start)//2
            
            
            if (mid==len(nums)-1 and nums[mid]==target) or (nums[mid]==target and nums[mid]<nums[mid+1]) :
                return mid
            else:
                if nums[mid] <= target:
                    start=mid+1
                else:
                    end=mid-1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        start_pos=self.right_search(nums,target)
        end_pos=self.left_search(nums,target,start_pos)
        
        return [start_pos,end_pos]
        
        
            
        