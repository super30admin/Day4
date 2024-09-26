# Time Complexity : O(log(n))
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums: 
            return 0
        
        l = 0
        h = len(nums)-1
        while nums[l] > nums[h]:
            mid = (l+h)//2
            if nums[mid] < nums[h]:
             
                h = mid
            else:
                l = mid+1
        return nums[l]  