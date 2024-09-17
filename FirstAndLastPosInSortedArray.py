# Time Complexity : O(log n) 95ms //Based on leetcode runtime
#  Space Complexity : O(1) 15.4 //Based on leetcode
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        return [self.firstOccur(nums, target), self.lastOccur(nums, target)]
    
    #This gives us the first index with binary search based on low
    def firstOccur(self,nums,target):
        low,high = 0, len(nums) - 1            
        while low < high:
            mid = (low+high) // 2
            if nums[mid] < target:
                low = mid + 1
            else:
                high = mid
        return low if nums[low] == target else -1
        
   #This gives us the second index with binary search based on low     
    def lastOccur(self,nums,target):
        low,high = 0, len(nums) - 1
        while low < high:
            #adding the one extra index to prevent it from stucking in loop
            mid = (low+high) // 2 + 1
                
            if nums[mid] > target:
                high = mid - 1
            else:
                low = mid
        return low if nums[low] == target else -1