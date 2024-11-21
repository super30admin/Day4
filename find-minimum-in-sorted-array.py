# Time Complexity : log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, I passed nums[mid:] in the rightsearchRange() fucntion instead of nums as whole. This approch was incorrect as the edited nums losses the original index.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[low]<=nums[high]:
                return nums[low]
            if( mid==0 or nums[mid]<=nums[mid-1]) and (nums[mid]<=nums[mid+1] or mid==len(nums)-1):
                return nums[mid]
            elif nums[low]<=nums[mid]:
                low=mid+1
            elif nums[mid]<=nums[high]:
                high=mid-1