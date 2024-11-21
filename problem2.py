#Time complexity O(log n) and Space complexity O(1)
#was able to run on leetcode
class Solution:
    def findMin(self, nums: List[int]) -> int:
        s=0
        e=len(nums)-1
        if nums[0]<nums[-1]:
            return nums[0]
        
        if len(nums)==1:
            return nums[0]
#Applying Binary search        
        while s<=e:
            m = s+(e-s)//2
            
            if nums[m]>nums[m+1]:
                return nums[m+1]
        
            if nums[s] <= nums[m]:
                s=m+1
            else:
                e=m-1
            
                        
        return [-1,-1]