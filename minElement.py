# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def get_ind(self,left,right,nums):
            if nums[left] <nums[right]:
                return 0
            while left <= right:
                mid = (left+right)//2
                if nums[mid] > nums[mid+1]:
                    return mid+1
                else:
                    if nums[mid] <nums[left]:
                        right = mid-1
                    else:
                        left = mid+1
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        rot_ind = self.get_ind(0,len(nums)-1,nums)
        return nums[rot_ind]
        
        
