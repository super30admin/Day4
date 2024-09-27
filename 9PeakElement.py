"""
LC:162
// Time Complexity :O(n2) for BF,O(Log n) using Binary search
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Missed base case for index
0 and last index-> Array index out of bound
"""

#Brute force
from typing import List
"""
class Solution:

  #Brute force
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)
        for i in range(l,h):
          if (i!=0 and nums[i]>nums[i-1] and nums[i]>nums[i+1]):
            return i
"""
 #Iterative solution
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)
        mid=int(l+(h-l)/2)

        while(l<=h):
          mid=int(l+(h-l)/2)
          if (len(nums)==0 or nums is None): #Base case
            return -1
          else:
            if (nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]):
              return mid
            elif nums[mid-1]>nums[mid]:
              h=mid-1
            else:
              l=mid+1

if __name__=="__main__"
s=Solution()
nums = [1,2,1,3,5,6,4]
print("Peak Element Idx=",s.findPeakElement(nums))
