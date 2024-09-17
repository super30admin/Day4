# brute force : iterate linearly, check if the number is the neighbourhood max, on left, right 
# Time Complexity : O(n)
# Space Complexity : O(1)

# Time Complexity : O (log n)
# Space Complexity : O (1)
# Did this code successfully run on Leetcode : yes

# Your code here along with comments explaining your approach
# Main idea is find local maximum element, find the max element in the neighbourhood of mid 
# if mid+1>mid, l=mid+1
# else r=mid

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums)-1
        
        while(l<r):
            mid = l + (r-l)//2
            if(nums[mid]<nums[mid+1]):
                l = mid+1
            else:
                r = mid
                
        return l        