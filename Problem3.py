# Time Complexity : O(logn)
# Space Complexity : O(logn) for call stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took time 


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        return self.binaryParse(nums,0,len(nums)-1)
    def binaryParse(self,arr,l,r):
        if l==r:
            return l
        m = (l+r)//2
        if arr[m] > arr[m+1]:
            return self.binaryParse(arr,l,m)
        return self.binaryParse(arr,m+1,r)
        