# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        s , e = 0, len(nums)-1
        
        while(s<e):
            
            mid = s+(e-s) //2
            
            # chaeck for left inflation
            if nums[mid] > nums[mid+1]:
                e= mid
            # check for right inflation
            else:
                s = mid +1
            
        # return the final sigle element
        return s
        