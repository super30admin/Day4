// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        if high==0:
            return nums[0]
        while low<=high:
            mid=low+(high-low)//2
            if((mid==0 or nums[mid-1]>nums[mid]) and ((mid==len(nums)-1) or nums[mid+1]>nums[mid])):
                return nums[mid]
            elif nums[mid]>nums[high]:
                low=mid+1
            else:
                high=mid-1
        return -1
            
        
