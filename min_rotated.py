// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if(nums==None or len(nums)==0):
            return -1
        low=0
        high=len(nums)-1
        if(nums[low]<=nums[high]):
            return nums[low]
        while(low<=high):
            if(nums[low]<=nums[high]):
                return nums[low]
            mid=(low+high)//2
            if((mid==0 or nums[mid]<nums[mid-1]  ) and (mid==len(nums)-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[mid]>=nums[low]):
                low=mid+1
            else:
                high=mid-1
        return 1313138
        
