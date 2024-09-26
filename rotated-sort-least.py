# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes


# // Your code here along with comments explaining your approach


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(mid==0 or nums[mid]<nums[mid-1])and(mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            if(nums[low]<nums[high]):
                return nums[low]
            if(nums[low]<=nums[mid]):
                low=mid+1
            else:
                high=mid-1
