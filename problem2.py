# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        
        if h == -1:
            return h
        
        if nums[0] <= nums[-1]:
            return nums[0]
        else:
            while l <= h:
                m = l + (h-l)//2
                print(l, m, h)
                if nums[m] > nums[m+1]:
                    return nums[m+1]
                    
                elif nums[l] <= nums[m]:
                    l = m+1
                else:
                    h = m-1