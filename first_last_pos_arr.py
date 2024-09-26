""" Time Complexity : O(logn)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No """

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            return [-1,-1]
        if target < nums[0] or target > nums[-1]:
            return [-1,-1]
        else:
            left = self.binarySearch(nums,0,len(nums) - 1,target,left=True)
            if left == -1:
                return [-1,-1]
            right = self.binarySearch(nums,0,len(nums) - 1,target,left=False)
            
            return [left,right]
        
    def binarySearch(self,nums,low,high,target,left=True):
        
        while low<=high:
            
            mid = int(low + (high-low)/2)
            
            if nums[mid] == target:
                
                if left:
                    if mid == 0 or nums[mid-1] < target:
                        return mid
                    else:
                        high = mid - 1
                else:
                    if mid == len(nums)-1 or nums[mid+1] > target:
                        return mid
                    else:
                        low = mid + 1
                        
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
            
        return -1
                    
            
        
        
        