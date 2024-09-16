# Time Complexity : O(logN); 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Binary Search


class Solution:
    def findMin(self, nums: List[int]) -> int:
        s, e = 0, len(nums)-1
        if nums[s] < nums[e] or len(nums)<2:
            return nums[s] # array is sorted already
        while(s<=e):
            mid = (e-s)//2+s
            #finding pivot element
            if mid != 0 and nums[mid-1]>nums[mid]:
                return nums[mid]
            elif nums[mid] < nums[e]:
                e = mid -1 
            else:
                s = mid +1
        
