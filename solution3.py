# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def find_peak_element(self, nums):
        
        left,right=0,len(nums)-1
        
        # binary search
        while left < right:
            mid = left + (right-left)//2
            # always going towards increasing trend, a bit counter-intuitive but we always get a peak value
            if nums[mid] > nums[mid+1]:
                right=mid
            else:
                left=mid+1
        return left