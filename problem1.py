// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    
    def leftSearch(self, nums: List[int], target: int) ->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target and (mid==0 or nums[mid-1]<target):
                return mid
            elif target<=nums[mid]:
                high=mid-1
            else:
                low=mid+1
        return -1
                
        
    def rightSearch(self, nums: List[int], target: int) ->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if(nums[mid]==target and (mid==len(nums)-1 or nums[mid+1]>target)):
                return mid
            elif target>=nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.leftSearch(nums,target),self.rightSearch(nums, target)]
        
